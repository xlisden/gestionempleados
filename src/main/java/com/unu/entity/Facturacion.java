package com.unu.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Facturacion")
public class Facturacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FactId")
    private int id;

    @Column(name = "FactFechaPago")
    private LocalDate fechaPago;

    @Column(name = "FactSueldoNeto")
    private double sueldoNeto;

    @ManyToOne()
    @JoinColumn(name = "FactEmpleado", foreignKey = @ForeignKey(name = "fk_facturacion_empleado"))
    private Empleado empleado;

    public Facturacion() {
    }

    public Facturacion(int id, LocalDate fechaPago, double sueldoNeto, Empleado empleado) {
        this.id = id;
        this.fechaPago = fechaPago;
        this.sueldoNeto = sueldoNeto;
        this.empleado = empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int facturacionCod) {
        this.id = facturacionCod;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getSueldoNeto() {
        return sueldoNeto;
    }

    public void setSueldoNeto(double sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }


}
