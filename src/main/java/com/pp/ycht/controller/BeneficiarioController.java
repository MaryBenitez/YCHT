package com.pp.ycht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BeneficiarioController {

    //BENEFICIARIOS
    @RequestMapping("/verBeneficiarios")
    public String verBeneficiarios(Model model) {
        //model.addAttribute("donantes", repo.findAll());
        return "admin/beneficiarios/mantenimientoVerBeneficiarios";
    }
}
