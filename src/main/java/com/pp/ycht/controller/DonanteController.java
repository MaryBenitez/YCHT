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
    private IDonanteRepo repo;


    @Autowired
    private DonanteService service;

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

    //Crear
    @RequestMapping("/new")
    public String newDonante(Model model) {
        Donante donante = new Donante();
        model.addAttribute("donante", donante);

        return "admin/donantes/mantenimientoCrearDonante";
    }

    //Guardar/Actualizar
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveDonane(@ModelAttribute("product") Donante donante) {
        service.save(donante);

        return "redirect:/verDonantes";
    }

    //Editar
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("admin/donantes/mantenimientoEditarDonante");
        Donante donante = service.get(id);
        mav.addObject("donante", donante);

        return mav;
    }

    @RequestMapping(value="/borrar/{id}", method= RequestMethod.GET)
    public String borrar(@PathVariable("id") Integer id, Model model){
        repo.delete(repo.getOne(id));
        //model.addAttribute("donantes", repo.findAll());
        return "redirect:/verDonantes";
    }

}
