package com.pp.ycht.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "donante")
public class Donante {

    @Id
    @GeneratedValue(generator = "donante_iddonante_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "donante_iddonante_seq", sequenceName = "public.donante_iddonante_seq", allocationSize = 1)
    @Column(name="iddonante")
    private int idDonante;

    @Column(name="nombre")
    private String nombreDonante;

    @Column(name="apellido")
    private String apellidoDonante;

    @Column(name="edad")
    private int edadDonante;

    public Donante() {}

    public Donante(int idDonante, String nombreDonante, String apellidoDonante, int edadDonante) {
        this.idDonante = idDonante;
        this.nombreDonante = nombreDonante;
        this.apellidoDonante = apellidoDonante;
        this.edadDonante = edadDonante;
    }

    public int getIdDonante() {
        return idDonante;
    }

    public void setIdDonante(int idDonante) {
        this.idDonante = idDonante;
    }

    public String getNombreDonante() {
        return nombreDonante;
    }

    public void setNombreDonante(String nombreDonante) {
        this.nombreDonante = nombreDonante;
    }

    public String getApellidoDonante() {
        return apellidoDonante;
    }

    public void setApellidoDonante(String apellidoDonante) {
        this.apellidoDonante = apellidoDonante;
    }

    public int getEdadDonante() {
        return edadDonante;
    }

    public void setEdadDonante(int edadDonante) {
        this.edadDonante = edadDonante;
    }

}
