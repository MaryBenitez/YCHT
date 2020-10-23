package com.pp.ycht.reposity;

import com.pp.ycht.domain.Donante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDonanteRepo extends JpaRepository<Donante,Integer> {

  @Query("SELECT d FROM Donante d WHERE CONCAT(d.nombreDonante, ' ', d.apellidoDonante, ' ', d.userDonante) LIKE %?1%")
  List<Donante> search(String keyword);
}

