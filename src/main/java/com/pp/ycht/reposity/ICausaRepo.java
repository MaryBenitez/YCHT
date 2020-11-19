package com.pp.ycht.reposity;

import com.pp.ycht.domain.Beneficiario;
import com.pp.ycht.domain.Causas;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface ICausaRepo extends JpaRepository<Causas,Integer> {
}
