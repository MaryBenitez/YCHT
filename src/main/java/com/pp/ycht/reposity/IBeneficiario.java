package com.pp.ycht.reposity;

import com.pp.ycht.domain.Beneficiario;
import com.pp.ycht.domain.Donante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBeneficiario extends JpaRepository<Beneficiario,Integer> {

    @Query("SELECT b FROM Beneficiario b WHERE b.estadoBeneficiario = false")
    List<Beneficiario> solicitudes();

}
