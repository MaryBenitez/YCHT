package com.pp.ycht.service;

import com.pp.ycht.domain.Beneficiario;
import com.pp.ycht.domain.Causas;
import com.pp.ycht.domain.Rol;
import com.pp.ycht.domain.Usuario;
import com.pp.ycht.reposity.IBeneficiario;
import com.pp.ycht.reposity.ICausaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class CausasService {

    @Autowired
    private ICausaRepo causaRepository;

    @Autowired
    private IBeneficiario beneficiarioRepository;


    public List<Causas> listAll(String keyword) {
        if (keyword != null) {
            return causaRepository.search(keyword);
        }
        return causaRepository.findAll();
    }

    public Causas saveCausas(Causas causas) {
        return causaRepository.save(causas);
    }
}
