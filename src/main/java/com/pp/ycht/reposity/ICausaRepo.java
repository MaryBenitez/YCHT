package com.pp.ycht.reposity;

import com.pp.ycht.domain.Causas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ICausaRepo extends JpaRepository<Causas,Integer> {

    @Query("select c from Causas c where c.tipoCausa like %?1%")
    List<Causas> search(String keyword);

    @Query("select c from Causas c where c.tipoCausa = 'Asilos'")
    List<Causas> findByCausaAsilo(String tipoCausa);

    @Query("select c from Causas c where c.tipoCausa = 'Contrucción'")
    List<Causas> findByCausaContru(String tipoCausa);

    @Query("select c from Causas c where c.tipoCausa = 'Animales'")
    List<Causas> findByCausaAnimales(String tipoCausa);

}
