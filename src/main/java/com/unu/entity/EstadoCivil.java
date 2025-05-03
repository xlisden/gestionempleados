package com.unu.entity;

//<editor-fold defaultstate="collapsed" desc=" Librerías...">

import jakarta.persistence.*;
//</editor-fold>

@Entity
@Table(name = "EstadoCivil")
public class EstadoCivil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EstCivilId")
    private int id;

    @Column(name = "EstCivilNombre", length = 10)
    private String nombre;


    public EstadoCivil() {
    }

    public EstadoCivil(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int estCivilCod) {
        this.id = estCivilCod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
