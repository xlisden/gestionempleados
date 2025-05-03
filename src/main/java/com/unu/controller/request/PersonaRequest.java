package com.unu.controller.request;

import com.unu.entity.EstadoCivil;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class PersonaRequest {

    @Size(min = 1, max = 20, message = "El nombre es requerido.")
    private String nombre;

//    @NotNull()
//    private boolean genero;

//    @NotNull(message = "El Estado Civil es requerido.")
    private EstadoCivil estadoCivil;

//    @NotNull(message = "La fecha de nacimiento es requerida.")
    private LocalDate fechaNacimiento;

    public PersonaRequest() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    public boolean isGenero() {
//        return genero;
//    }
//
//    public void setGenero(boolean genero) {
//        this.genero = genero;
//    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
