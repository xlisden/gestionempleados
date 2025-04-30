package com.unu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ModalidadesContrato")
public class ModalidadContrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ModContId")
    private int id;

    @Column(name = "ModContNombre", length = 20)
    private String nombre;

    public ModalidadContrato() {
    }

    public ModalidadContrato(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
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
