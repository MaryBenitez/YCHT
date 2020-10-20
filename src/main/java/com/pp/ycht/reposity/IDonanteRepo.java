package com.pp.ycht.reposity;

import com.pp.ycht.domain.Donante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDonanteRepo extends JpaRepository<Donante,Integer> {
}
