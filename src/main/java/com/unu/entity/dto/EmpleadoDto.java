package com.unu.entity.dto;

public class EmpleadoDto {

    private int id;
    private String cod;
    private String nombreCompleto;
    private String area;
    private String antiguedad;
    private String modalidadContrato;
    private String jornadaLaboral;
    private boolean activo;

    public EmpleadoDto() {
    }

    public int getId() {
        return this.id;
    }

    public String getCod() {
        return this.cod;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public String getArea() {
        return this.area;
    }

    public String getAntiguedad() {
        return this.antiguedad;
    }

    public String getModalidadContrato() {
        return this.modalidadContrato;
    }

    public String getJornadaLaboral() {
        return this.jornadaLaboral;
    }

    public boolean isActivo() {
        return this.activo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void setModalidadContrato(String modalidadContrato) {
        this.modalidadContrato = modalidadContrato;
    }

    public void setJornadaLaboral(String jornadaLaboral) {
        this.jornadaLaboral = jornadaLaboral;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
