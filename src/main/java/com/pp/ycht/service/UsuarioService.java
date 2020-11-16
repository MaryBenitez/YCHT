package com.pp.ycht.service;

import com.pp.ycht.domain.Donante;
import com.pp.ycht.domain.Rol;
import com.pp.ycht.domain.Usuario;
import com.pp.ycht.reposity.IDonanteRepo;
import com.pp.ycht.reposity.IRolReposity;
import com.pp.ycht.reposity.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IRolReposity rolReposity;

    @Autowired
    BCryptPasswordEncoder encoder;

    public List<Usuario> listAll() {
        return usuarioRepository.findAll();
    }

    public void saveUserDonante(Usuario usuario) {
        //contraseña encriptada
        usuario.setPass(encoder.encode(usuario.getPass()));
        //Setea el usuario true
        usuario.setEstado(true);
        //Setea el tipo de usuario
        usuario.setTipousuario("Donante");
        //Setea el rol user
        Rol rol = rolReposity.findByRol("USER");
        Rol rol2 = rolReposity.findByRol("DONANTE");
        usuario.setRoles(new HashSet<Rol>(Arrays.asList(rol,rol2)));
        //Guarda usuario
        usuarioRepository.save(usuario);
    }

    public void saveUserBeneficiario(Usuario usuario) {
        //contraseña encriptada
        usuario.setPass(encoder.encode(usuario.getPass()));
        //Setea el tipo de usuario
        usuario.setTipousuario("Beneficiario");
        //Setea el usuario true
        usuario.setEstado(true);
        //Setea el rol user
        Rol rol = rolReposity.findByRol("USER");
        Rol rol2 = rolReposity.findByRol("BENEFICIARIO");
        usuario.setRoles(new HashSet<Rol>(Arrays.asList(rol,rol2)));
        //Guarda usuario
        usuarioRepository.save(usuario);
    }

    public void saveAdmin(Usuario usuario) {
        //contraseña encriptada
        usuario.setPass(encoder.encode(usuario.getPass()));
        //Setea el usuario true
        usuario.setEstado(true);
        //Setea el tipo de usuario
        usuario.setTipousuario("Administrador");
        //Setea el rol user
        Rol rol = rolReposity.findByRol("ADMIN");
        usuario.setRoles(new HashSet<Rol>(Arrays.asList(rol)));
        //Guarda usuario
        usuarioRepository.save(usuario);
    }

    public Usuario get(Integer id) {
        return usuarioRepository.findById(id).get();
    }

}
