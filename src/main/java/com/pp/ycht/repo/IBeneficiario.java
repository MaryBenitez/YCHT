package com.pp.ycht.repo;

import com.pp.ycht.domain.Beneficiario;
import com.pp.ycht.domain.Donante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBeneficiario extends JpaRepository<Beneficiario,Integer> {
}
