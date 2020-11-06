package com.pp.ycht.controller;

import com.pp.ycht.domain.Beneficiario;
import com.pp.ycht.domain.Donante;
import com.pp.ycht.domain.Usuario;
import com.pp.ycht.service.BeneficiarioService;
import com.pp.ycht.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BeneficiarioController {


    @Autowired
    private BeneficiarioService serviceBeneficiario;

    @Autowired
    private UsuarioService serviceUsuario;

    @RequestMapping("/admin/beneficiarios")
    public String beneficiarios() {
        return "admin/beneficiarios/mantenimientoBeneficiarios";
    }

    //Listado soli
    @RequestMapping("/admin/beneficiarios/solicitudesB")
    public String verSolicitudesB(Model model) {
        model.addAttribute("beneficiarios", serviceBeneficiario.listSoli());
        return "admin/beneficiarios/mantenimientoVerSolicitudesB";
    }
    
    //aceptar solis
    @RequestMapping("/admin/beneficiarios/aceptarBeneficiario/{id}")
    public String aceptarBeneficiario(@PathVariable(name = "id") int id, Model model) {

        Beneficiario beneficiario = serviceBeneficiario.get(id);
        beneficiario.setEstadoBeneficiario(true);
        List<Beneficiario> beneficiarios = serviceBeneficiario.listSoli();
        model.addAttribute("beneficiario", beneficiarios);

        return "redirect:/admin/beneficiarios/solicitudesB";
    }
    //Rechazar solicitudes
    @RequestMapping("/admin/beneficiarios/rechazarBeneficiario/{id}")
    public String rechazarBeneficiario(@PathVariable(name = "id") int id) {
        serviceBeneficiario.deleteBeneficiario(id);
        return "redirect:/admin/beneficiarios/solicitudesB";
    }

    //BENEFICIARIO VISTA
    @RequestMapping("/admin/beneficiarios/verBeneficiarios")
    public String verBeneficiarios(ModelMap modelMap) {
        List<Beneficiario> beneficiarios = serviceBeneficiario.listAll();
        List<Usuario> usuarios = serviceUsuario.listAll();
        modelMap.addAttribute("beneficiarios", beneficiarios);
        modelMap.addAttribute("usuarios", usuarios);


        return "admin/beneficiarios/mantenimientoVerBeneficiarios";
    }

    //Crear Beneficiario VISTA
    @RequestMapping("/beneficiarios/newBeneficiario")
    public String newBeneficiario(Model model) {
        Beneficiario beneficiario = new Beneficiario();
        model.addAttribute("beneficiario", beneficiario);

        return "admin/beneficiarios/mantenimientoCrearBeneficiario";
    }

    //Crear Usuario VISTA
    @RequestMapping("/beneficiario/newUserBeneficiario")
    public String newUserBeneficiario(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);

        return "admin/beneficiarios/mantenimientoCrearUsuarioBeneficiario";
    }

    //Guardar datos Beneficiario
    @RequestMapping(value = "/beneficiarios/saveBeneficiario", method = RequestMethod.POST)
    public String saveBeneficiario(@ModelAttribute("beneficiario") Beneficiario beneficiario) {
        serviceBeneficiario.saveBeneficiario(beneficiario);

        return "redirect:/beneficiario/newUserBeneficiario";
    }

    //Guardar Usuario
    @RequestMapping(value = "/beneficiarios/saveUsuarioB", method = RequestMethod.POST)
    public String saveUserBeneficiario(@ModelAttribute("usuario") Usuario usuario) {
        serviceUsuario.saveUserBeneficiario(usuario);
        return "redirect:/login";
    }

    //Actualizar Beneficiario
    @RequestMapping(value = "/admin/beneficiarios/updatebeneficiario", method = RequestMethod.POST)
    public String updateBeneficiario(@ModelAttribute("beneficiario") Beneficiario beneficiario) {
        beneficiario.setEstadoBeneficiario(true);
        serviceBeneficiario.saveBeneficiario(beneficiario);
        return "redirect:/admin/beneficiarios/verBeneficiarios";
    }

    //Editar datos Beneficiario
    @RequestMapping("/admin/beneficiarios/editBeneficiario/{id}")
    public ModelAndView Editbeneficiario(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("admin/beneficiarios/mantenimientoEditarBeneficiario");
        Beneficiario beneficiario = serviceBeneficiario.get(id);
        mav.addObject("beneficiario", beneficiario);

        return mav;
    }

    //Borrar
    @RequestMapping("/admin/beneficiarios/deleteBeneficiario/{id}")
    public String deleteBeneficiario(@PathVariable(name = "id") int id) {
        serviceBeneficiario.deleteBeneficiario(id);
        return "redirect:/admin/beneficiarios/verBeneficiarios";
    }


}
