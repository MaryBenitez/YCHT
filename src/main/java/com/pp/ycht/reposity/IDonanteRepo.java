package com.pp.ycht.reposity;

import com.pp.ycht.domain.Donante;
import com.pp.ycht.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDonanteRepo extends JpaRepository<Donante,Integer> {

  @Query("select d from Donante d where concat(d.nombreDonante, ' ', d.apellidoDonante, ' ') like %?1%")
  List<Donante> search(String keyword);

  @Modifying
  @Query("delete from Donante where idDonante = ?1")
  void deleteByid(Integer id);

}

