package com.pp.ycht.reposity;

import com.pp.ycht.domain.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBeneficiario extends JpaRepository<Beneficiario,Integer> {
}
