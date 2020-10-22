package com.pp.ycht.controller;

import com.pp.ycht.reposity.IDonanteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private IDonanteRepo repo;

    //Principal index
    @RequestMapping("/")
    public String index() {

        return "index";
    }

    //Login de Usuarios
    @RequestMapping("/login")
    public String login() {

        return "index";
    }

    //Login Administrador
    @RequestMapping("/loginAdmin")
    public String loginAdmin() {

        return "admin/adminLogin";
    }

    //Principal de Mantenimiento
    @RequestMapping("/admin")
    public String home() {

        return "admin/mantenimiento";
    }

}
