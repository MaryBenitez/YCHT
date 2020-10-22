package com.pp.ycht.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Donante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pk_iddonante")
    private int idDonante;

    @Column(name="nombre")
    private String nombreDonante;

    @Column(name="apellido")
    private String apellidoDonante;

    @Column(name="edad")
    private int edadDonante;

    @Column(name="estado")
    private boolean estadoDonante;

    @Column(name="nombre_usuario")
    private String userDonante;

    @Column(name="contrasenia_usuario")
    private String passDonante;

    public Donante() {
    }

    public Donante(int idDonante, String nombreDonante, String apellidoDonante, int edadDonante, boolean estadoDonante, String userDonante, String passDonante) {
        this.idDonante = idDonante;
        this.nombreDonante = nombreDonante;
        this.apellidoDonante = apellidoDonante;
        this.edadDonante = edadDonante;
        this.estadoDonante = estadoDonante;
        this.userDonante = userDonante;
        this.passDonante = passDonante;
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

    public boolean isEstadoDonante() {
        return estadoDonante;
    }

    public void setEstadoDonante(boolean estadoDonante) {
        this.estadoDonante = estadoDonante;
    }

    public String getUserDonante() {
        return userDonante;
    }

    public void setUserDonante(String userDonante) {
        this.userDonante = userDonante;
    }

    public String getPassDonante() {
        return passDonante;
    }

    public void setPassDonante(String passDonante) {
        this.passDonante = passDonante;
    }

}
