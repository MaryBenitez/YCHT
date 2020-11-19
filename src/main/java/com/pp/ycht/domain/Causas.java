package com.pp.ycht.domain;

import javax.persistence.*;

@Entity
@Table(name = "causas")
public class Causas {

    @Id
    @GeneratedValue(generator = "causas_idcausa_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "causas_idcausa_seq", sequenceName = "public.causas_idcausa_seq", allocationSize = 1)
    @Column(name="idcausa")
    private int idcausa;

    @Column(name="nombre")
    private String nombre;

    @Column(name="detalle_causa")
    private String detalleCausa;

    @Column(name="estado")
    private boolean estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idbeneficiario")
    private Beneficiario beneficiario;

    public Causas() {}

    public Causas(int idcausa, String nombre, String detalleCausa, boolean estado, Beneficiario beneficiario) {
        this.idcausa = idcausa;
        this.nombre = nombre;
        this.detalleCausa = detalleCausa;
        this.estado = estado;
        this.beneficiario = beneficiario;
    }

    public int getIdcausa() {
        return idcausa;
    }

    public void setIdcausa(int idcausa) {
        this.idcausa = idcausa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalleCausa() {
        return detalleCausa;
    }

    public void setDetalleCausa(String detalleCausa) {
        this.detalleCausa = detalleCausa;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }
}
