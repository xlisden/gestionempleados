package com.unu.entity.dto;

public class FacturacionDto {

    private int id;
    private String empleado;
    private String fechaPago;
    private double sueldoNeto;

    public FacturacionDto() {
    }

    public int getId() {
        return this.id;
    }

    public String getEmpleado() {
        return this.empleado;
    }

    public String getFechaPago() {
        return this.fechaPago;
    }

    public double getSueldoNeto() {
        return this.sueldoNeto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void setSueldoNeto(double sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }
}
