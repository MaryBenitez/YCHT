package com.pp.ycht.controller;

import com.pp.ycht.domain.Beneficiario;
import com.pp.ycht.domain.Donante;
import com.pp.ycht.domain.Usuario;
import com.pp.ycht.reposity.IDonanteRepo;
import com.pp.ycht.service.BeneficiarioService;
import com.pp.ycht.service.DonanteService;
import com.pp.ycht.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController{

    @Autowired
    private IDonanteRepo repo;
    @Autowired
    private DonanteService serviceDonante;
    @Autowired
    private BeneficiarioService serviceBeneficiario;
    @Autowired
    private UsuarioService serviceUsuario;

    //Principal index
    @RequestMapping("/")
    public String index(ModelMap modelMap, @Param("keyword") String keyword) {

        List<Donante> donantes = serviceDonante.listAll(keyword);
        List<Beneficiario> beneficiarios = serviceBeneficiario.listAll();
        List<Usuario> usuarios = serviceUsuario.listAll();
        modelMap.addAttribute("donantes", donantes);
        modelMap.addAttribute("beneficiarios", beneficiarios);
        modelMap.addAttribute("usuarios", usuarios);

        modelMap.addAttribute("keyword", keyword);
        return "indexDonantes";
    }

    //Login de Usuarios
   @GetMapping(value = {"/login"})
    public String login(Principal principal){
        return principal == null ? "login" : "redirect:/";
    }

    @RequestMapping("/index")
    public String donantes1() {
        return "index";
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

        mav.setViewName("error/403");
        return mav;

    }

}
