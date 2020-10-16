package com.pp.ycht.controller;

import com.pp.ycht.domain.Donante;
import com.pp.ycht.repo.IDonanteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private IDonanteRepo repo;

    @RequestMapping("/")
    public String greeting() {
        Donante donante = new Donante();

        //CREATE
		donante.setIdDonante(50);
		donante.setNombreDonante("pruebita");

		repo.save(donante);
        return "index";
    }

    @RequestMapping("/login")
    public String login(){

        return "login";
    }

}
