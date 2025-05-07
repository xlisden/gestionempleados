package com.unu.entity.dto;

public class ContratoDto {

    private int id;
    private int idEmpleado;
    private String empleado;
    private String antiguedad;
    private String modalidadContrato;
    private String fechaEmision;
    private String fechaInicio;
    private String fechaFin;
    private String area;
    private double sueldoBasico;
    private String jornadaLaboral;

    public ContratoDto() {
    }

    public int getId() {
        return this.id;
    }

    public String getAntiguedad() {
        return this.antiguedad;
    }

    public String getModalidadContrato() {
        return this.modalidadContrato;
    }

    public String getFechaInicio() {
        return this.fechaInicio;
    }

    public String getFechaFin() {
        return this.fechaFin;
    }

    public String getArea() {
        return this.area;
    }

    public double getSueldoBasico() {
        return this.sueldoBasico;
    }

    public String getJornadaLaboral() {
        return this.jornadaLaboral;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void setModalidadContrato(String modalidadContrato) {
        this.modalidadContrato = modalidadContrato;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public void setJornadaLaboral(String jornadaLaboral) {
        this.jornadaLaboral = jornadaLaboral;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
}
