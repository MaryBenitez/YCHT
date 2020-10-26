package com.pp.ycht.controller;

import com.pp.ycht.domain.Donante;
import com.pp.ycht.service.DonanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @RequestMapping("/admin/donantes")
    public String donantes() {
        return "admin/donantes/mantenimientoDonantes";
    }

    //DONANTES
    @RequestMapping("/admin/donantes/verDonantes")
    public String verDonantes(Model model, @Param("keyword") String keyword) {
        List<Donante> donantes = service.listAll(keyword);
        model.addAttribute("donantes", donantes);
        model.addAttribute("keyword", keyword);

        return "admin/donantes/mantenimientoVerDonantes";
    }

    //Crear
    @RequestMapping("/admin/donantes/newDonante")
    public String newDonante(Model model) {
        Donante donante = new Donante();
        model.addAttribute("donante", donante);

        return "admin/donantes/mantenimientoCrearDonante";
    }

    //Guardar/Actualizar
    @RequestMapping(value = "/admin/donantes/saveDonante", method = RequestMethod.POST)
    public String saveDonante(@ModelAttribute("donante") Donante donante) {
        service.save(donante);

        return "redirect:/login";
    }

    //Editar
    @RequestMapping("/admin/donantes/editDonante/{id}")
    public ModelAndView editDonantes(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("admin/donantes/mantenimientoEditarDonante");
        Donante donante = service.get(id);
        mav.addObject("donante", donante);

        return mav;
    }

    //Borrar
    @RequestMapping("/admin/donantes/deleteDonante/{id}")
    public String deleteDonante(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/admin/donantes/verDonantes";
    }

}
