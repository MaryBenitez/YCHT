package com.pp.ycht.reposity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolReposity extends JpaRepository<Rol,Integer> {
    public Rol findByRol(String rol);
}
