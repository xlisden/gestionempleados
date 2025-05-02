package com.unu.entity;

//<editor-fold defaultstate="collapsed" desc=" Librerías...">

import jakarta.persistence.*;
//</editor-fold>ss

@Entity
@Table(name = "JornadaLaboral")
public class JornadaLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JLabId")
    private int id;

    @Column(name = "JLabNombre", length = 20)
    private String nombre;

    public JornadaLaboral() {
    }

    public JornadaLaboral(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int jLabCodigo) {
        this.id = jLabCodigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
