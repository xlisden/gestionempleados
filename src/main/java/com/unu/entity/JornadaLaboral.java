package com.unu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "JorandasLaborales")
public class JornadaLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JLabId")
    private int id;

    @Column(name = "JLabNombre", length = 20)
    private String nombre;

    public JornadaLaboral() {
    }

    public JornadaLaboral(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getjId() {
        return id;
    }

    public void setjId(int jLabCodigo) {
        this.id = jLabCodigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
