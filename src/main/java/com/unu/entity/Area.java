package com.unu.entity;

//<editor-fold defaultstate="collapsed" desc=" Librerías...">

import jakarta.persistence.*;
//</editor-fold>

@Entity
@Table(name = "Area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AreaId")
    private int id;

    @Column(name = "AreaNombre", length = 20)
    private String nombre;

    @Column(name = "AreaSueldoBasico")
    private double sueldoBasico;

    public Area() {
    }

    public Area(String nombre, double sueldoBasico) {
        this.nombre = nombre;
        this.sueldoBasico = sueldoBasico;
    }

    public int getId() {
        return id;
    }

    public void setId(int idArea) {
        this.id = idArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double salario) {
        this.sueldoBasico = salario;
    }

}
