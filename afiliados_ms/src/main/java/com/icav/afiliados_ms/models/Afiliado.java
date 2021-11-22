package com.icav.afiliados_ms.models;

import org.springframework.data.annotation.Id;

public class Afiliado {
    @Id
    private Integer identificacion;
    private String nombres;
    private String apellidos;
    private Integer edad;
    private String medidaEdad;
    private String sexo;
    private String correo;
    private String ciudad;
    private String direccion;

    public Afiliado(Integer identificacion, String nombres, String apellidos, Integer edad, String medidaEdad, String sexo, String correo, String ciudad, String direccion) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.medidaEdad = medidaEdad;
        this.sexo = sexo;
        this.correo = correo;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getMedidaEdad() {
        return medidaEdad;
    }

    public void setMedidaEdad(String medidaEdad) {
        this.medidaEdad = medidaEdad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
