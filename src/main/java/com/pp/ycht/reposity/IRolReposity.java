package com.pp.ycht.reposity;

import com.pp.ycht.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolReposity extends JpaRepository<Rol,Integer> {
    public Rol findByRol(String rol);
}
