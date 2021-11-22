package com.icav.afiliados_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Vacuna {
    @Id
    private Integer id;
    private Integer idPersona;
    private String fabricante;
    private Integer lote;
    private Integer dosis;
    private Date fechaAplicacion;

    public Vacuna(Integer id, Integer idPersona, String fabricante, Integer lote, Integer dosis, Date fechaAplicacion) {
        this.id = id;
        this.idPersona = idPersona;
        this.fabricante = fabricante;
        this.lote = lote;
        this.dosis = dosis;
        this.fechaAplicacion = fechaAplicacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }

    public Integer getDosis() {
        return dosis;
    }

    public void setDosis(Integer dosis) {
        this.dosis = dosis;
    }

    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }
}
