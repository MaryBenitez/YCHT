package com.pp.ycht.service;

import com.pp.ycht.domain.Beneficiario;
import com.pp.ycht.reposity.IBeneficiario;
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
        return repo.aceptados();
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

    public List<Beneficiario> listSoli() {
        return repo.solicitudes();
    }
}
