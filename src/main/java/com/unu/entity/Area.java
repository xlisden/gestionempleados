package com.unu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Areas")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AreaId")
    private int id;

    @Column(name = "AreaCod", length = 5)
    private String cod;

    @Column(name = "AreaNombre", length = 20)
    private String nombre;

    @Column(name = "AreaSueldoBasico")
    private double sueldoBasico;

    public Area() {
        super();
    }

    public Area(int id, String cod, String nombre, double sueldoBasico) {
        super();
        this.id = id;
        this.cod = cod;
        this.nombre = nombre;
        this.sueldoBasico = sueldoBasico;
    }

    public int getId() {
        return id;
    }

    public void setId(int idArea) {
        this.id = idArea;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String areaCod) {
        this.cod = areaCod;
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
