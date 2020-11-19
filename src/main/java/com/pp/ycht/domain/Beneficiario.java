package com.pp.ycht.domain;

import javax.persistence.*;

@Entity
@Table(name = "beneficiario")
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idbeneficiario")
    private int idBeneficiario;

    @Column(name="nombre")
    private String nombreBeneficiario;

    @Column(name="descripcion")
    private String descripcionBeneficiario;

    @Column(name="email")
    private String correoBeneficiario;

    @Column(name="telefono")
    private String telefonoBeneficiario;

    @Column(name="anio_fundacion")
    private int edadBeneficiario;

    @Column(name="estado")
    private boolean estadoBeneficiario;

    public Beneficiario() {}

    public Beneficiario(int idBeneficiario, String nombreBeneficiario, String descripcionBeneficiario, int edadBeneficiario, boolean estadoBeneficiario) {
        this.idBeneficiario = idBeneficiario;
        this.nombreBeneficiario = nombreBeneficiario;
        this.descripcionBeneficiario = descripcionBeneficiario;
        this.edadBeneficiario = edadBeneficiario;
        this.estadoBeneficiario = estadoBeneficiario;
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

    public String getDescripcionBeneficiario() {
        return descripcionBeneficiario;
    }

    public void setDescripcionBeneficiario(String descripcionBeneficiario) {
        this.descripcionBeneficiario = descripcionBeneficiario;
    }

    public String getCorreoBeneficiario() {
        return correoBeneficiario;
    }

    public void setCorreoBeneficiario(String correoBeneficiario) {
        this.correoBeneficiario = correoBeneficiario;
    }

    public String getTelefonoBeneficiario() {
        return telefonoBeneficiario;
    }

    public void setTelefonoBeneficiario(String telefonoBeneficiario) {
        this.telefonoBeneficiario = telefonoBeneficiario;
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

}
