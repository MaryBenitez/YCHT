package com.pp.ycht.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pk_idbeneficiario")
    private int idBeneficiario;

    @Column(name="nombre")
    private String nombreBeneficiario;

    @Column(name="descripcion")
    private String descripcionBeneficiario;

    @Column(name="anio_fundacion")
    private int edadBeneficiario;

    @Column(name="estado")
    private boolean estadoBeneficiario;

    @Column(name="nombre_usuario")
    private String userBeneficiario;

    @Column(name="contrasenia_usuario")
    private String passBeneficiario;

    public Beneficiario() {
    }

    public Beneficiario(int idBeneficiario, String nombreBeneficiario, String descripcionBeneficiario, int edadBeneficiario, boolean estadoBeneficiario, String userBeneficiario, String passBeneficiario) {
        this.idBeneficiario = idBeneficiario;
        this.nombreBeneficiario = nombreBeneficiario;
        this.descripcionBeneficiario = descripcionBeneficiario;
        this.edadBeneficiario = edadBeneficiario;
        this.estadoBeneficiario = estadoBeneficiario;
        this.userBeneficiario = userBeneficiario;
        this.passBeneficiario = passBeneficiario;
    }

    public int getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(int idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public String getNombreBeneficiario() {
        return nombreBeneficiario;
    }

    public void setNombreBeneficiario(String nombreBeneficiario) {
        this.nombreBeneficiario = nombreBeneficiario;
    }

    public int getEdadBeneficiario() {
        return edadBeneficiario;
    }

    public void setEdadBeneficiario(int edadBeneficiario) {
        this.edadBeneficiario = edadBeneficiario;
    }

    public boolean isEstadoBeneficiario() {
        return estadoBeneficiario;
    }

    public void setEstadoBeneficiario(boolean estadoBeneficiario) {
        this.estadoBeneficiario = estadoBeneficiario;
    }

    public String getUserBeneficiario() {
        return userBeneficiario;
    }

    public void setUserBeneficiario(String userBeneficiario) {
        this.userBeneficiario = userBeneficiario;
    }

    public String getPassBeneficiario() {
        return passBeneficiario;
    }

    public void setPassBeneficiario(String passBeneficiario) {
        this.passBeneficiario = passBeneficiario;
    }

    public String getDescripcionBeneficiario() {
        return descripcionBeneficiario;
    }

    public void setDescripcionBeneficiario(String descripcionBeneficiario) {
        this.descripcionBeneficiario = descripcionBeneficiario;
    }
<<<<<<< HEAD
=======

>>>>>>> front
}
