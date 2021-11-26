package com.icav.afiliados_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Contagio {
    private Integer idPersona;
    private Date fechaDiagnostico;
    private String estadoEnfermedad;
    private String ubicacionCaso;
    private String estadoRecuperacion;
    private Date fechaRecuperacion;
    private Date fechaMuerte;

    public Contagio(Integer idPersona, Date fechaDiagnostico, String estadoEnfermedad, String ubicacionCaso, String estadoRecuperacion, Date fechaRecuperacion, Date fechaMuerte) {
        this.idPersona = idPersona;
        this.fechaDiagnostico = fechaDiagnostico;
        this.estadoEnfermedad = estadoEnfermedad;
        this.ubicacionCaso = ubicacionCaso;
        this.estadoRecuperacion = estadoRecuperacion;
        this.fechaRecuperacion = fechaRecuperacion;
        this.fechaMuerte = fechaMuerte;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Date getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(Date fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public String getEstadoEnfermedad() {
        return estadoEnfermedad;
    }

    public void setEstadoEnfermedad(String estadoEnfermedad) {
        this.estadoEnfermedad = estadoEnfermedad;
    }

    public String getUbicacionCaso() {
        return ubicacionCaso;
    }

    public void setUbicacionCaso(String ubicacionCaso) {
        this.ubicacionCaso = ubicacionCaso;
    }

    public String getEstadoRecuperacion() {
        return estadoRecuperacion;
    }

    public void setEstadoRecuperacion(String estadoRecuperacion) {
        this.estadoRecuperacion = estadoRecuperacion;
    }

    public Date getFechaRecuperacion() {
        return fechaRecuperacion;
    }

    public void setFechaRecuperacion(Date fechaRecuperacion) {
        this.fechaRecuperacion = fechaRecuperacion;
    }

    public Date getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(Date fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }
}