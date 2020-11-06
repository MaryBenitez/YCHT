package com.pp.ycht.service;

import com.pp.ycht.domain.Donante;
import com.pp.ycht.domain.Usuario;
import com.pp.ycht.reposity.IDonanteRepo;
import com.pp.ycht.reposity.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DonanteService {

    @Autowired
    private IDonanteRepo donanteRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;



    public List<Donante> listAll(String keyword) {
        if (keyword != null) {
            donanteRepository.search(keyword);
            usuarioRepository.search(keyword);
        }
        return donanteRepository.findAll();
    }

    public void saveDonante(Donante donante) {
        donanteRepository.save(donante);
    }

    public Donante get(Integer id) {
        return donanteRepository.findById(id).get();
    }

    public void deleteDonante(Integer id) {
        donanteRepository.deleteByid(id);
    }

}
