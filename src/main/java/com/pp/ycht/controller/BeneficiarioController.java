package com.pp.ycht.controller;

import com.pp.ycht.repo.IBeneficiario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BeneficiarioController {

    @Autowired
    private IBeneficiario repo;

    //BENEFICIARIOS
    @RequestMapping("/verBeneficiarios")
    public String verBeneficiarios(Model model) {
        model.addAttribute("beneficiarios", repo.findAll());
        return "admin/beneficiarios/mantenimientoVerBeneficiarios";
    }

}
