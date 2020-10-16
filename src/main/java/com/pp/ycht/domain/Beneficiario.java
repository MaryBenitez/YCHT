package com.pp.ycht.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Beneficiario {

    @Id
    @Column(name="pk_idbeneficiario")
    private int idBeneficiario;

    @Column(name="nombre")
    private String nombreBeneficiario;

    @Column(name="apellido")
    private String apellidoBeneficiario;

    @Column(name="edad")
    private int edadBeneficiario;

    @Column(name="estado")
    private boolean estadoBeneficiario;

    @Column(name="nombre_usuario")
    private String userBeneficiario;

    @Column(name="contrasenia_usuario")
    private String passBeneficiario;

    public Beneficiario() {
    }

    public Beneficiario(int idBeneficiario, String nombreBeneficiario, String apellidoBeneficiario, int edadBeneficiario, boolean estadoBeneficiario, String userBeneficiario, String passBeneficiario) {
        this.idBeneficiario = idBeneficiario;
        this.nombreBeneficiario = nombreBeneficiario;
        this.apellidoBeneficiario = apellidoBeneficiario;
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

    public String getApellidoBeneficiario() {
        return apellidoBeneficiario;
    }

    public void setApellidoBeneficiario(String apellidoBeneficiario) {
        this.apellidoBeneficiario = apellidoBeneficiario;
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
}
