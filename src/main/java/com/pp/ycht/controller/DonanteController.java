package com.pp.ycht.controller;

import com.pp.ycht.domain.Donante;
import com.pp.ycht.service.DonanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DonanteController {

    @Autowired
    private DonanteService service;

    @RequestMapping("/donantes")
    public String index() {

        return "admin/donantes/mantenimientoDonantes";
    }

    //DONANTES
    @RequestMapping("/verDonantes")
    public String verDonantes(Model model) {
        //model.addAttribute("donantes", service.findByApellidoDonante("Murillo"));
        model.addAttribute("donantes", service.listAll());
        return "admin/donantes/mantenimientoVerDonantes";
    }

    //Filtrar
   /* @RequestMapping("/verDonantesFiltrado")
    public String filtrarDonantes(Model model) {
        model.addAttribute("donantes", service.findByApellidoDonante("Benitez"));
        //model.addAttribute("donantes", service.listAll());
        return "admin/donantes/mantenimientoVerDonantes";
    }*/
    @RequestMapping("/verDonantesFiltrado/{valor}")
    public ModelAndView filtrarDonantes(@PathVariable(name = "valor") String valor) {
        ModelAndView mav = new ModelAndView("admin/donantes/mantenimientoVerDonantes");
        List<Donante> donantes = service.findByApellidoDonante(valor);
        mav.addObject("donantes", donantes);

        return mav;
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

        return "redirect:/login";
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
