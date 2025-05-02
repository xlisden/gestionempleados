package com.unu.entity;

//<editor-fold defaultstate="collapsed" desc=" Librerías...">

import jakarta.persistence.*;
//</editor-fold>

@Entity
@Table(name = "ModalidadContrato")
public class ModalidadContrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ModContId")
    private int id;

    @Column(name = "ModContNombre", length = 20)
    private String nombre;

    public ModalidadContrato() {
    }

    public ModalidadContrato(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int idModalidad) {
        this.id = idModalidad;
    }
}
