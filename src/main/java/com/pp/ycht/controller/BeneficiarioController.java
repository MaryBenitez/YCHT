package com.pp.ycht.controller;

import com.pp.ycht.domain.Beneficiario;
import com.pp.ycht.domain.Donante;
import com.pp.ycht.domain.Usuario;
import com.pp.ycht.service.BeneficiarioService;
import com.pp.ycht.service.DonanteService;
import com.pp.ycht.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class BeneficiarioController {

    @Autowired
    private DonanteService serviceDonante;

    @Autowired
    private BeneficiarioService serviceBeneficiario;

    @Autowired
    private UsuarioService serviceUsuario;

    //////////////////PRINCIPAL////////////////////
    //Loggeado como beneficiario
    @RequestMapping("/beneficiario")
    public String indexB(ModelMap modelMap, @Param("keyword") String keyword) {

        List<Donante> donantes = serviceDonante.listAll(keyword);
        List<Beneficiario> beneficiarios = serviceBeneficiario.listAll();
        modelMap.addAttribute("donantes", donantes);
        modelMap.addAttribute("beneficiarios", beneficiarios);

        modelMap.addAttribute("keyword", keyword);
        return "views/beneficiario/indexBeneficiario";
    }
    @RequestMapping("/beneficiario/perfil")
    public ModelAndView verPerfilBeneficiario(Principal usuario) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", usuario.getName());
        mav.setViewName("views/beneficiario/verMiPerfilB");
        return mav;
    }

    @RequestMapping("/beneficiario/perfilDonante/{id}")
    public ModelAndView verPerfilDonanteEnB(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("views/beneficiario/perfilDonante");
        Donante donante = serviceDonante.get(id);
        mav.addObject("donante", donante);

        return mav;
    }

    //////////////////PRINCIPAL////////////////////

    //////////////////ADMIND//////////////////////
    @RequestMapping("/admin/beneficiarios")
    public String beneficiarios() {
        return "admin/beneficiarios/mantenimientoBeneficiarios";
    }

    //Listado soli
    @RequestMapping("/admin/beneficiarios/solicitudesB")
    public String verSolicitudesB(Model model) {
        model.addAttribute("beneficiarios", serviceBeneficiario.listSoli());
        return "admin/beneficiarios/mantenimientoVerSolicitudesB";
    }
    
    //aceptar solis
    @RequestMapping("/admin/beneficiarios/aceptarBeneficiario/{id}")
    public String aceptarBeneficiario(@PathVariable(name = "id") int id, Model model) {

        Beneficiario beneficiario = serviceBeneficiario.get(id);
        beneficiario.setEstadoBeneficiario(true);
        List<Beneficiario> beneficiarios = serviceBeneficiario.listSoli();
        model.addAttribute("beneficiario", beneficiarios);

        return "redirect:/admin/beneficiarios/solicitudesB";
    }
    //Rechazar solicitudes
    @RequestMapping("/admin/beneficiarios/rechazarBeneficiario/{id}")
    public String rechazarBeneficiario(@PathVariable(name = "id") int id) {
        serviceBeneficiario.deleteBeneficiario(id);
        return "redirect:/admin/beneficiarios/solicitudesB";
    }

    //BENEFICIARIO VISTA
    @RequestMapping("/admin/beneficiarios/verBeneficiarios")
    public String verBeneficiarios(ModelMap modelMap) {
        List<Beneficiario> beneficiarios = serviceBeneficiario.listAll();
        List<Usuario> usuarios = serviceUsuario.listAll();
        modelMap.addAttribute("beneficiarios", beneficiarios);
        modelMap.addAttribute("usuarios", usuarios);


        return "admin/beneficiarios/mantenimientoVerBeneficiarios";
    }

    //Crear Beneficiario VISTA
    @RequestMapping("/beneficiarios/newBeneficiario")
    public String newBeneficiario(Model model) {
        Beneficiario beneficiario = new Beneficiario();
        model.addAttribute("beneficiario", beneficiario);

        return "admin/beneficiarios/mantenimientoCrearBeneficiario";
    }

    //Crear Usuario VISTA
    @RequestMapping("/beneficiarios/newUserBeneficiario")
    public String newUserBeneficiario(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);

        return "admin/beneficiarios/mantenimientoCrearUsuarioBeneficiario";
    }

    //Guardar datos Beneficiario
    @RequestMapping(value = "/beneficiarios/saveBeneficiario", method = RequestMethod.POST)
    public String saveBeneficiario(@ModelAttribute("beneficiario") Beneficiario beneficiario) {
        serviceBeneficiario.saveBeneficiario(beneficiario);

        return "redirect:/beneficiarios/newUserBeneficiario";
    }

    //Guardar Usuario
    @RequestMapping(value = "/beneficiarios/saveUsuarioB", method = RequestMethod.POST)
    public ModelAndView saveUser(@Valid Usuario usuario, BindingResult bindingResult, ModelMap modelMap){
        ModelAndView mav = new ModelAndView();
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors().toString());
            mav.addObject("errorMessage","Por favor corrija los errores");
            modelMap.addAttribute("bidingResult",bindingResult);
            mav.setViewName("redirect:/beneficiarios/newUserBeneficiario");
        }else if(serviceUsuario.ifUserExist(usuario)){
            mav.addObject("verifyMessage","El usuario ya existe");
            mav.setViewName("redirect:/beneficiarios/newUserBeneficiario");
        }else{
            serviceUsuario.saveUserBeneficiario(usuario);
            mav.addObject("successMessage","Usuario Registrado");
            mav.addObject("usuario", new Usuario());
            mav.setViewName("redirect:/login");
        }
        return mav;
    }

    //Actualizar Beneficiario
    @RequestMapping(value = "/admin/beneficiarios/updatebeneficiario", method = RequestMethod.POST)
    public String updateBeneficiario(@ModelAttribute("beneficiario") Beneficiario beneficiario) {
        beneficiario.setEstadoBeneficiario(true);
        serviceBeneficiario.saveBeneficiario(beneficiario);
        return "redirect:/admin/beneficiarios/verBeneficiarios";
    }

    //Editar datos Beneficiario
    @RequestMapping("/admin/beneficiarios/editBeneficiario/{id}")
    public ModelAndView Editbeneficiario(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("admin/beneficiarios/mantenimientoEditarBeneficiario");
        Beneficiario beneficiario = serviceBeneficiario.get(id);
        mav.addObject("beneficiario", beneficiario);

        return mav;
    }

    //Borrar
    @RequestMapping("/admin/beneficiarios/deleteBeneficiario/{id}")
    public String deleteBeneficiario(@PathVariable(name = "id") int id) {
        serviceBeneficiario.deleteBeneficiario(id);
        return "redirect:/admin/beneficiarios/verBeneficiarios";
    }


}
