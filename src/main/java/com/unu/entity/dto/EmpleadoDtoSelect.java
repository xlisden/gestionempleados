package com.unu.entity.dto;

public class EmpleadoDtoSelect {

    private int id;
    private String nombreCompleto;

    public EmpleadoDtoSelect() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
