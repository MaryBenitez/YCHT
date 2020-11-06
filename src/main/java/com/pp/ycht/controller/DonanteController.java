package com.pp.ycht.controller;

import com.pp.ycht.domain.Donante;
import com.pp.ycht.domain.Usuario;
import com.pp.ycht.service.DonanteService;
import com.pp.ycht.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DonanteController {

    @Autowired
    private DonanteService serviceDonante;

    @Autowired
    private UsuarioService serviceUsuario;

    @RequestMapping("/admin/donantes")
    public String donantes() {
        return "admin/donantes/mantenimientoDonantes";
    }

    //DONANTES VISTA
    @RequestMapping("/admin/donantes/verDonantes")
    public String verDonantes(ModelMap modelMap, @Param("keyword") String keyword) {
        List<Donante> donantes = serviceDonante.listAll(keyword);
        List<Usuario> usuarios = serviceUsuario.listAll();
        modelMap.addAttribute("donantes", donantes);
        modelMap.addAttribute("usuarios", usuarios);

        modelMap.addAttribute("keyword", keyword);

        return "admin/donantes/mantenimientoVerDonantes";
    }

    //Crear Donante VISTA
    @RequestMapping("/donantes/newDonante")
    public String newDonante(Model model) {
        Donante donante = new Donante();
        model.addAttribute("donante", donante);

        return "admin/donantes/mantenimientoCrearDonante";
    }

    //Crear Usuario VISTA
    @RequestMapping("/donantes/newUserDonante")
    public String newUserDonante(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);

        return "admin/donantes/mantenimientoCrearUsuarioDonante";
    }

    //Guardar datos de Donante
    @RequestMapping(value = "/donantes/saveDonante", method = RequestMethod.POST)
    public String saveDonante(@ModelAttribute("donante") Donante donante) {
        serviceDonante.saveDonante(donante);
        return "redirect:/donantes/newUserDonante";
    }

    //Actualizar Donante
    @RequestMapping(value = "/admin/donantes/updateDonante", method = RequestMethod.POST)
    public String updateDonante(@ModelAttribute("donante") Donante donante) {
        serviceDonante.saveDonante(donante);
        return "redirect:/admin/donantes/verDonantes";
    }

    //Guardar Usuario
    @RequestMapping(value = "/donantes/saveUsuarioD", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("usuario") Usuario usuario) {
        serviceUsuario.saveUserDonante(usuario);
        return "redirect:/login";
    }

    //Editar datos Donante VISTA
    @RequestMapping("/admin/donantes/editDonante/{id}")
    public ModelAndView editDonantes(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("admin/donantes/mantenimientoEditarDonante");
        Donante donante = serviceDonante.get(id);
        mav.addObject("donante", donante);

        return mav;
    }

    //Borrar
    @RequestMapping("/admin/donantes/deleteDonante/{id}")
    public String deleteDonante(@PathVariable(name = "id") int id) {
        serviceDonante.deleteDonante(id);
        return "redirect:/admin/donantes/verDonantes";
    }

}
