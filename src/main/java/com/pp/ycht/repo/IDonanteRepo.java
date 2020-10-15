package com.pp.ycht.repo;

import com.pp.ycht.domain.Donante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IDonanteRepo extends JpaRepository<Donante,Integer> {
}
