package com.unu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EstadosCiviles")
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

    public int getEstCivilCod() {
        return id;
    }

    public void setEstCivilCod(int estCivilCod) {
        this.id = estCivilCod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
