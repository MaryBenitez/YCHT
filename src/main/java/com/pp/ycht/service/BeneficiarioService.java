package com.pp.ycht.service;

import com.pp.ycht.domain.Beneficiario;
import com.pp.ycht.reposity.IBeneficiario;
import com.pp.ycht.reposity.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BeneficiarioService {

    @Autowired
    private IBeneficiario beneficiarioRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public List<Beneficiario> listAll() {
        return beneficiarioRepository.aceptados();
    }

    public void saveBeneficiario(Beneficiario beneficiario) {
        this.beneficiarioRepository.save(beneficiario);
    }

    public Beneficiario get(Integer id) {
        return beneficiarioRepository.findById(id).get();
    }

    public void deleteBeneficiario(Integer id) {
        beneficiarioRepository.deleteById(id);
    }

    public List<Beneficiario> listSoli() {
        return beneficiarioRepository.solicitudes();
    }
}
