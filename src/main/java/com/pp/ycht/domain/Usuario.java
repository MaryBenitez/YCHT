package com.pp.ycht.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(generator = "usuario_idusuario_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "usuario_idusuario_seq", sequenceName = "public.usuario_idusuario_seq", allocationSize = 1)
    @Column(name = "idusuario")
    private int idusuario;

    @Column(name="username")
    private String username;

    @Column(name="pass")
    private String pass;

    @Column(name="tipousuario")
    private String tipousuario;

    @Column(name="estado")
    private boolean estado;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "rol_usuario", joinColumns = @JoinColumn(name = "idusuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<Rol> roles;

    public Usuario() {}

    public Usuario(int idusuario, String username, String pass, String tipousuario, boolean estado, Set<Rol> roles) {
        this.idusuario = idusuario;
        this.username = username;
        this.pass = pass;
        this.tipousuario = tipousuario;
        this.estado = estado;
        this.roles = roles;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
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

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
