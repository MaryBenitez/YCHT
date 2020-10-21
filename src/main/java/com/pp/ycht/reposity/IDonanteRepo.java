package com.pp.ycht.reposity;

import com.pp.ycht.domain.Donante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDonanteRepo extends JpaRepository<Donante,Integer> {

    @Query("select D from Donante D where D.apellidoDonante like 'Murillo'")
    List<Donante> findByApellidoDonante(String name);
}
