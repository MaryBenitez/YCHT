package com.pp.ycht.controller;

import com.pp.ycht.domain.Donante;
import com.pp.ycht.repo.IDonanteRepo;
import com.pp.ycht.service.DonanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DonanteController {

    @Autowired
    private DonanteService service;

    //DONANTES
    @RequestMapping("/verDonantes")
    public String verDonantes(Model model) {
        model.addAttribute("donantes", service.listAll());
        return "admin/beneficiarios/mantenimientoVerDonantes";
    }

    //Crear
    @RequestMapping("/newDonante")
    public String newDonante(Model model) {
        Donante donante = new Donante();
        model.addAttribute("donante", donante);

        return "admin/donantes/mantenimientoCrearDonante";
    }

    //Guardar/Actualizar
    @RequestMapping(value = "/saveDonante", method = RequestMethod.POST)
    public String saveDonante(@ModelAttribute("donante") Donante donante) {
        service.save(donante);

        return "redirect:/verDonantes";
    }

    //Editar
    @RequestMapping("/editDonante/{id}")
    public ModelAndView editDonantes(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("admin/donantes/mantenimientoEditarDonante");
        Donante donante = service.get(id);
        mav.addObject("donante", donante);

        return mav;
    }

    //Borrar
    @RequestMapping("/deleteDonante/{id}")
    public String deleteDonante(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/verDonantes";
    }

}
