package com.pp.ycht.controller;

import com.pp.ycht.domain.Donante;
import com.pp.ycht.domain.Usuario;
import com.pp.ycht.reposity.IUsuarioRepository;
import com.pp.ycht.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class AdminController {

    @Autowired
    private UsuarioService serviceUsuario;

    //Login Administrador VISTA
    @RequestMapping("/loginAdministrador")
    public String loginAdminView() {
        return "admin/loginAdmin";
    }

    //Principal de Mantenimiento VISTA
    @RequestMapping("/admin")
    public String home() {
        return "admin/mantenimiento";
    }

    //Login de Administrador
    @GetMapping(value = {"/loginAdmin"})
    public String loginAdmin(Principal principal){
        return principal == null ? "loginAdmin" : "redirect:/admin";
    }

    //Nuevo Administrador VISTA
    @RequestMapping("/administrador/newAdmin")
    public String registroAdmin(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "admin/registroAdmin";
    }

    //Guardar Usuario
    @RequestMapping(value = "/administrador/saveAdmin", method = RequestMethod.POST)
    public String saveAdmin(@ModelAttribute("usuario") Usuario usuario) {
        serviceUsuario.saveAdmin(usuario);
        return "redirect:/loginAdministrador";
    }
}