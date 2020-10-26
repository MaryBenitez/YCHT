package com.pp.ycht.service;

import com.pp.ycht.domain.Donante;
import com.pp.ycht.domain.Rol;
import com.pp.ycht.reposity.IDonanteRepo;
import com.pp.ycht.reposity.IRolReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class DonanteService {

    @Autowired
    private IDonanteRepo repo;

    @Autowired
    private IRolReposity rolReposity;

    @Autowired
    BCryptPasswordEncoder encoder;

    public List<Donante> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public void save(Donante donante) {
        donante.setPass(encoder.encode(donante.getPass()));
        donante.setEstadoDonante(true);
        Rol rol = rolReposity.findByRol("USER");
        donante.setRoles(new HashSet<Rol>(Arrays.asList(rol)));
        repo.save(donante);
    }

    public Donante get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteByid(id);
    }

}
