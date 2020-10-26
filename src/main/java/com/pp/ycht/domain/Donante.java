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

    @Column(name="estado")
    private boolean estadoDonante;

    @Column(name="nombre_usuario")
    private String username;

    @Column(name="contrasenia_usuario")
    private String pass;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "rol_donante", joinColumns = @JoinColumn(name = "iddonante"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<Rol> roles;

    public Donante() {}

    public Donante(int idDonante, String nombreDonante, String apellidoDonante, int edadDonante, boolean estadoDonante, String username, String pass, Set<Rol> roles) {
        this.idDonante = idDonante;
        this.nombreDonante = nombreDonante;
        this.apellidoDonante = apellidoDonante;
        this.edadDonante = edadDonante;
        this.estadoDonante = estadoDonante;
        this.username = username;
        this.pass = pass;
        this.roles = roles;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
