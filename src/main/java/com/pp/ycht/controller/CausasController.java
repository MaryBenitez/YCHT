package com.pp.ycht.controller;

import com.pp.ycht.domain.Beneficiario;
import com.pp.ycht.domain.Causas;
import com.pp.ycht.domain.Usuario;
import com.pp.ycht.service.BeneficiarioService;
import com.pp.ycht.service.CausasService;
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
public class CausasController {

    @Autowired
    private CausasService serviceCausas;
    @Autowired
    private BeneficiarioService serviceBeneficiario;

    //Causas VISTA DESDE ADMIN
    @RequestMapping("/admin/causas/verCausas")
    public String verCausas(ModelMap modelMap,@Param("keyword") String keyword) {
        List<Causas> causas = serviceCausas.listAll(keyword);
        modelMap.addAttribute("causas", causas);
        modelMap.addAttribute("keyword", keyword);

        return "admin/causas/mantenimientoVerCausas";
    }

    //Causas VISTA
    @RequestMapping("/beneficiario/verCausas")
    public String verMisCausas(ModelMap modelMap,@Param("keyword") String keyword) {
        List<Causas> causas = serviceCausas.listAll(keyword);
        modelMap.addAttribute("causas", causas);
        modelMap.addAttribute("keyword", keyword);

        return "views/beneficiario/VerMisCausas";
    }
    //Causas VISTA DONANTE
    @RequestMapping("/donante/verCausas")
    public String verCausasD(ModelMap modelMap, @Param("keyword") String keyword) {
        List<Causas> causas = serviceCausas.listAll(keyword);
        modelMap.addAttribute("causas", causas);
        modelMap.addAttribute("keyword", keyword);

        return "views/donante/VerCausas";
    }

    //Crear Causas VISTA
    @RequestMapping("/beneficiario/newCausas")
    public ModelAndView newCausas() {
        ModelAndView mav = new ModelAndView("views/beneficiario/CrearCausa");
        Causas causas = new Causas();
        mav.addObject("causas", causas);

        return mav;
    }

    //Guardar Causa
    @RequestMapping(value = "/beneficiario/saveCausa", method = RequestMethod.POST)
    public String saveBeneficiario(@ModelAttribute("causas") Causas causas) {
        serviceCausas.saveCausas(causas);
        return "redirect:/beneficiario/perfil";
    }
}
