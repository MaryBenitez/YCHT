package com.pp.ycht.reposity;

import com.pp.ycht.domain.Donante;
import com.pp.ycht.domain.Rol;
import com.pp.ycht.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query("select u from Usuario u where u.username like %?1%")
    List<Usuario> search(String keyword);

    public Usuario findByUsername(String username);

}
