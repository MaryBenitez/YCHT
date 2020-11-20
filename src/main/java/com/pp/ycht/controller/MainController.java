package com.pp.ycht.controller;

import com.pp.ycht.domain.Beneficiario;
import com.pp.ycht.domain.Causas;
import com.pp.ycht.domain.Donante;
import com.pp.ycht.domain.Usuario;
import com.pp.ycht.reposity.ICausaRepo;
import com.pp.ycht.reposity.IDonanteRepo;
import com.pp.ycht.service.BeneficiarioService;
import com.pp.ycht.service.CausasService;
import com.pp.ycht.service.DonanteService;
import com.pp.ycht.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController{

    @Autowired
    private IDonanteRepo repo;
    @Autowired
    private ICausaRepo causaRepo;

    @Autowired
    private CausasService serviceCausa;

    //Login de Usuarios
   @GetMapping(value = {"/login"})
    public String login(Principal principal){
        return principal == null ? "login" : "redirect:/";
    }

    @RequestMapping("/index")
    public ModelAndView donantes1(@ModelAttribute("causas") Causas causas) {
        ModelAndView mav = new ModelAndView("index");

        List<Causas> asilos = causaRepo.findByCausaAsilo();
        mav.addObject("asilos", asilos);

        List<Causas> contrucciones = causaRepo.findByCausaContru();
        mav.addObject("contrucciones", contrucciones);

        List<Causas> animales = causaRepo.findByCausaAnimales();
        mav.addObject("animales", animales);
        return mav;
    }
    //Error
    @GetMapping("/access-denied")
    public ModelAndView accessDenied(Principal usuario){
        ModelAndView mav = new ModelAndView();
        if (usuario != null) {
            mav.addObject("msg", "Hola, " + usuario.getName()
                    + ". Lo sentimos.");
        } else {
            mav.addObject("msg",
                    "Página no encontrada");
        }

        mav.setViewName("error/403");
        return mav;

    }

}
