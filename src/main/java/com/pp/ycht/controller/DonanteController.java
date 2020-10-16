package com.pp.ycht.controller;

import com.pp.ycht.domain.Donante;
import com.pp.ycht.repo.IDonanteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DonanteController {

    @Autowired
    private IDonanteRepo repo;

    //ADMIN
    @RequestMapping("/loginAdmin")
    public String loginAdmin() {

        return "admin/adminLogin";
    }

    //PRINCIPAL
    @RequestMapping("/admin")
    public String home() {

        return "admin/mantenimiento";
    }
    //DONANTES
    @RequestMapping("/verDonantes")
    public String verDonantes(Model model) {
        model.addAttribute("donantes", repo.findAll());
        return "admin/donantes/mantenimientoVerDonantes";
    }

    @RequestMapping(value="/editarDonante/{id}", method= RequestMethod.GET)
    public String editarDonante(@PathVariable("id") Integer id, Model model){
        //repo.getOne(id);
        model.addAttribute("donante", repo.getOne(id));
        return "admin/donantes/mantenimientoEditarDonante";
    }

    @RequestMapping(value="editarDonante/guardarDonante/{id}", method= RequestMethod.GET)
    public String guardarDonante(@PathVariable("id") Integer id, Model model){
        //repo.delete(repo.getOne(id));
        Donante d = repo.getOne(id);
        d.setNombreDonante("NUEVONAME");
        repo.saveAndFlush(d);
        //model.addAttribute("donantes", repo.findAll());
        return "redirect:/verDonantes";
    }

    @RequestMapping(value="/borrar/{id}", method= RequestMethod.GET)
    public String borrar(@PathVariable("id") Integer id, Model model){
        repo.delete(repo.getOne(id));
        //model.addAttribute("donantes", repo.findAll());
        return "redirect:/verDonantes";
    }

}