package com.pp.ycht.controller;

import com.pp.ycht.domain.Beneficiario;
import com.pp.ycht.domain.Donante;
import com.pp.ycht.repo.IBeneficiario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BeneficiarioController {

    @Autowired
    private IBeneficiario repo;

    //BENEFICIARIOS
    @RequestMapping("/verBeneficiarios")
    public String verBeneficiarios(Model model) {
        model.addAttribute("beneficiarios", repo.findAll());
        return "admin/beneficiarios/mantenimientoVerBeneficiarios";
    }

    @RequestMapping(value="/editarBeneficiario/{id}", method= RequestMethod.GET)
    public String editarBeneficiario(@PathVariable("id") Integer id, Model model){
        //repo.getOne(id);
        model.addAttribute("beneficiario", repo.getOne(id));
        return "admin/beneficiarios/mantenimientoEditarBeneficiario";
    }

    @RequestMapping(value="editarBeneficiario/guardarBeneficiario/{id}", method= RequestMethod.GET)
    public String guardarBeneficiario(@PathVariable("id") Integer id, Model model){
        //repo.delete(repo.getOne(id));
        Beneficiario b = repo.getOne(id);
        b.setNombreBeneficiario("NUEVONAMEBENEFICIARIO");
        repo.saveAndFlush(b);
        //model.addAttribute("donantes", repo.findAll());
        return "redirect:/verBeneficiarios";
    }

    @RequestMapping(value="/borrarBeneficiario/{id}", method= RequestMethod.GET)
    public String borrar(@PathVariable("id") Integer id, Model model){
        repo.delete(repo.getOne(id));
        //model.addAttribute("donantes", repo.findAll());
        return "redirect:/verBeneficiarios";
    }


}
