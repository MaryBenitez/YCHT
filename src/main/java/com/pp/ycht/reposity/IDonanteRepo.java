package com.pp.ycht.reposity;

import com.pp.ycht.domain.Donante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDonanteRepo extends JpaRepository<Donante,Integer> {

    List<Donante> findByLastname(String lastname);

}
