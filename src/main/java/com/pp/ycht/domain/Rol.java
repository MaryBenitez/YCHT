package com.pp.ycht.domain;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(generator = "rol_id_rol_seq1", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "rol_id_rol_seq1", sequenceName = "public.rol_id_rol_seq1", allocationSize = 1)
    @Column(name = "id_rol")
    private int id;

    @Column(name = "rol")
    private String rol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

