package com.unu.entity;

//<editor-fold defaultstate="collapsed" desc=" Librerías...">

import jakarta.persistence.*;
//</editor-fold>

@Entity
@Table(name = "Banco")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BancoId")
    private int id;

    @Column(name = "BancoNombre", length = 20)
    private String nombre;

    public Banco(int id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public Banco() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int idEntidad) {
        this.id = idEntidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
