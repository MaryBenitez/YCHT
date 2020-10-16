package com.pp.ycht.controller;

import com.pp.ycht.domain.Beneficiario;
import com.pp.ycht.domain.Donante;
import com.pp.ycht.repo.IBeneficiario;
import com.pp.ycht.repo.IDonanteRepo;
import com.pp.ycht.service.BeneficiarioService;
import com.pp.ycht.service.DonanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BeneficiarioController {


    @Autowired
    private BeneficiarioService service;

    @Autowired
    private IBeneficiario repo;

    //Beneficiarios
    @RequestMapping("/verBeneficiarios")
    public String verBeneficiarios(Model model) {
        model.addAttribute("beneficiarios", service.listAll());
        return "admin/beneficiarios/mantenimientoVerBeneficiarios";
    }

    //Crear
    @RequestMapping("/newBeneficiario")
    public String newBeneficiario(Model model) {
        Beneficiario beneficiario = new Beneficiario();
        model.addAttribute("beneficiario", beneficiario);

        return "admin/beneficiarios/mantenimientoCrearBeneficiario";
    }

    //Guardar/Actualizar
    @RequestMapping(value = "/saveBeneficiario", method = RequestMethod.POST)
    public String saveBeneficiario(@ModelAttribute("beneficiario") Beneficiario beneficiario) {
        service.save(beneficiario);

        return "redirect:/verBeneficiarios";
    }

    //Editar
    @RequestMapping("/editBeneficiario/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("admin/beneficiarios/mantenimientoEditarBeneficiario");
        Beneficiario beneficiario = service.get(id);
        mav.addObject("beneficiario", beneficiario);

        return mav;
    }

    @RequestMapping(value="/borrarBeneficiario/{id}", method= RequestMethod.GET)
    public String borrarBeneficiario(@PathVariable("id") Integer id, Model model){
        repo.delete(repo.getOne(id));
        return "redirect:/verBeneficiarios";
    }


}
