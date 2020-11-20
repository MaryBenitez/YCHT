package com.pp.ycht.controller;

import com.pp.ycht.domain.Beneficiario;
import com.pp.ycht.domain.Donante;
import com.pp.ycht.domain.Usuario;
import com.pp.ycht.reposity.IUsuarioRepository;
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
public class DonanteController {

    @Autowired
    private DonanteService serviceDonante;

    @Autowired
    private BeneficiarioService serviceBeneficiario;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService serviceUsuario;

    //////////////////PRINCIPAL//////////////////////////
    //Vista loggeado como Donante
    @RequestMapping("/donante")
    public String indexD(ModelMap modelMap, @Param("keyword") String keyword) {

        List<Donante> donantes = serviceDonante.listAll(keyword);
        List<Beneficiario> beneficiarios = serviceBeneficiario.listAll();
        modelMap.addAttribute("donantes", donantes);
        modelMap.addAttribute("beneficiarios", beneficiarios);

        modelMap.addAttribute("keyword", keyword);
        return "views/donante/indexDonantes";
    }

    @RequestMapping("/donante/perfil")
    public ModelAndView verPerfilDonante(Principal usuario) {
        ModelAndView mav = new ModelAndView();
        //usuarioRepository.findByUsername(usuario.getName());
        //mav.addObject("msg", usuarioRepository.findByUsername(usuario.getName()).getIdusuario());
        //mav.addObject("msg",serviceDonante.findByIdUserAndIdDonante(usuarioRepository.findByUsername(usuario.getName()).getIdusuario()));
        mav.addObject("msg",usuario.getName());
        mav.setViewName("views/beneficiario/verMiPerfilD");
        return mav;
    }

    //////////////////ADMIN/////////////////////////////
    @RequestMapping("/admin/donantes")
    public String donantes() {
        return "admin/donantes/mantenimientoDonantes";
    }

    //DONANTES VISTA
    @RequestMapping("/admin/donantes/verDonantes")
    public String verDonantes(ModelMap modelMap, @Param("keyword") String keyword) {
        List<Donante> donantes = serviceDonante.listAll(keyword);
        modelMap.addAttribute("donantes", donantes);
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
    public ModelAndView saveUser(@Valid Usuario usuario, BindingResult bindingResult, ModelMap modelMap){
        ModelAndView mav = new ModelAndView();
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors().toString());
            mav.addObject("errorMessage","Por favor corrija los errores");
            modelMap.addAttribute("bidingResult",bindingResult);
            mav.setViewName("redirect:/donantes/newUserDonante");
        }else if(serviceUsuario.ifUserExist(usuario)){
            mav.addObject("verifyMessage","El usuario ya existe");
            mav.setViewName("redirect:/donantes/newUserDonante");
        }else{
            serviceUsuario.saveUserDonante(usuario);
            mav.addObject("successMessage","Usuario Registrado");
            mav.addObject("usuario", new Usuario());
            mav.setViewName("redirect:/login");
        }
        return mav;
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

    //Vista perfil de beneficiario
    @RequestMapping("/donante/perfilBeneficiario/{id}")
    public ModelAndView verPerfilDonanteEnB(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("views/donante/perfilBeneficiario");
        Donante donante = serviceDonante.get(id);
        mav.addObject("donante", donante);

        return mav;
    }
    //////////////////ADMIN/////////////////////////////

}
