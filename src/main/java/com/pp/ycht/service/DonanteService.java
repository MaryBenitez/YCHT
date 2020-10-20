package com.pp.ycht.service;

import com.pp.ycht.domain.Donante;
import com.pp.ycht.reposity.IDonanteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DonanteService {

    @Autowired
    private IDonanteRepo repo;

    public List<Donante> listAll() {
        return repo.findAll();
    }

    public void save(Donante donante) {
        repo.save(donante);
    }

    public Donante get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
