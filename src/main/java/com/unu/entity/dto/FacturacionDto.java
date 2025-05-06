package com.unu.entity.dto;

public class FacturacionDto {

    private int id;
    private int idEmpleado;
    private String cod;
    private String dni;
    private String empleado;
    private String fechaPago;
    private double sueldoBruto;
    private double bonificacion;
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

    public double getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(double bonificacion) {
        this.bonificacion = bonificacion;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
