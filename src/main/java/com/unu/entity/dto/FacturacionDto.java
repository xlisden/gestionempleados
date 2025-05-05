package com.unu.entity.dto;

public class FacturacionDto {

    private int idEmpleado;
    private String cod;
    private String dni;
    private String empleado;
    private String fechaPago;
    private double sueldoBruto;
    private double bonificaciones;
    private double sueldoNeto;

    public FacturacionDto() {
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

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void setSueldoNeto(double sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public double getBonificaciones() {
        return bonificaciones;
    }

    public void setBonificaciones(double bonificaciones) {
        this.bonificaciones = bonificaciones;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
}
