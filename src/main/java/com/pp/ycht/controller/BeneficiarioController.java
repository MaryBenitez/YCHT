package com.pp.ycht.controller;

import com.pp.ycht.domain.Beneficiario;
import com.pp.ycht.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BeneficiarioController {


    @Autowired
    private BeneficiarioService service;

    @RequestMapping("/admin/beneficiarios")
    public String index() {

        return "admin/beneficiarios/mantenimientoBeneficiarios";
    }
    //Listado soli
    @RequestMapping("/admin/beneficiarios/solicitudesB")
    public String verSolicitudesB(Model model) {
        model.addAttribute("beneficiarios", service.listSoli());
        return "admin/beneficiarios/mantenimientoVerSolicitudesB";
    }
    
    //aceptar solis
    @RequestMapping("/admin/beneficiarios/aceptarBeneficiario/{id}")
    public String aceptarBeneficiario(@PathVariable(name = "id") int id, Model model) {

        Beneficiario beneficiario = service.get(id);
        beneficiario.setEstadoBeneficiario(true);
        List<Beneficiario> beneficiarios = service.listSoli();
        model.addAttribute("beneficiario", beneficiarios);

        return "redirect:/admin/beneficiarios/solicitudesB";
    }
    //Rechazar solicitudes
    @RequestMapping("/admin/beneficiarios/rechazarBeneficiario/{id}")
    public String rechazarBeneficiario(@PathVariable(name = "id") int id) {
        service.delete(id);

        return "redirect:/admin/beneficiarios/solicitudesB";
    }

    //Beneficiarios
    @RequestMapping("/admin/beneficiarios/verBeneficiarios")
    public String verBeneficiarios(Model model) {
        model.addAttribute("beneficiarios", service.listAll());
        return "admin/beneficiarios/mantenimientoVerBeneficiarios";
    }

    //Crear
    @RequestMapping("/admin/beneficiarios/newBeneficiario")
    public String newBeneficiario(Model model) {
        Beneficiario beneficiario = new Beneficiario();
        model.addAttribute("beneficiario", beneficiario);

        return "admin/beneficiarios/mantenimientoCrearBeneficiario";
    }

    //Guardar/Actualizar
    @RequestMapping(value = "/admin/beneficiarios/saveBeneficiario", method = RequestMethod.POST)
    public String saveBeneficiario(@ModelAttribute("beneficiario") Beneficiario beneficiario) {
        service.save(beneficiario);

        return "redirect:/login";
    }

    //Editar
    @RequestMapping("/admin/beneficiarios/editBeneficiario/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("admin/beneficiarios/mantenimientoEditarBeneficiario");
        Beneficiario beneficiario = service.get(id);
        mav.addObject("beneficiario", beneficiario);

        return mav;
    }

    //Borrar
    @RequestMapping("/admin/beneficiarios/deleteBeneficiario/{id}")
    public String deleteBeneficiario(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/admin/beneficiarios/verBeneficiarios";
    }


}
