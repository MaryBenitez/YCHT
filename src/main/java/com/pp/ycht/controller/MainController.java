package com.pp.ycht.controller;

import com.pp.ycht.reposity.IDonanteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class MainController{

    @Autowired
    private IDonanteRepo repo;

    //Principal index
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    //Login de Usuarios
   @GetMapping(value = {"/login"})
    public String login(Principal principal){
        return principal == null ? "login" : "redirect:/";
    }

    //Error
    @GetMapping("/access-denied")
    public ModelAndView accessDenied(Principal usuario){
        ModelAndView mav = new ModelAndView();
        if (usuario != null) {
            mav.addObject("msg", "Hola " + usuario.getName()
                    + ", la página no existe o fue eliminada");
        } else {
            mav.addObject("msg",
                    "Página no encontrada");
        }

        mav.setViewName("403");
        return mav;

    }

}
