package com.pp.ycht.service;

import com.pp.ycht.domain.Beneficiario;
import com.pp.ycht.domain.Donante;
import com.pp.ycht.repo.IBeneficiario;
import com.pp.ycht.repo.IDonanteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BeneficiarioService {

    @Autowired
    private IBeneficiario repo;

    public List<Beneficiario> listAll() {
        return repo.findAll();
    }

    public void save(Beneficiario beneficiario) {
        repo.save(beneficiario);
    }

    public Beneficiario get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
