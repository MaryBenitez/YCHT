package com.pp.ycht.controller;

import com.pp.ycht.domain.Donante;
import com.pp.ycht.repo.IDonanteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    private IDonanteRepo repo;

    @RequestMapping("/admin")
    public String greeting() {
        /*Donante donante = new Donante();

        //CREATE
        donante.setIdDonante(50);
        donante.setNombreDonante("pruebita");
        repo.save(donante);*/

        return "admin/mantenimiento";
    }

    @RequestMapping("/verDonantes")
    public String verDonantes(Model model) {
        model.addAttribute("donantes", repo.findAll());
        return "admin/donantes/mantenimientoVerDonantes";
    }
}
