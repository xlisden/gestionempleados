package com.unu.entity;

//<editor-fold defaultstate="collapsed" desc=" Librerías...">
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
//</editor-fold>

@Entity
@Table(name = "Area")
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
    }

    public Area(String cod, String nombre, double sueldoBasico) {
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
