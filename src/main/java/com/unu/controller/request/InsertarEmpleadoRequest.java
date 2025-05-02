package com.unu.controller.request;

import com.unu.entity.EstadoCivil;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class InsertarEmpleadoRequest {

    @Size(min = 1, max = 6)
    private String cod;

    @Size(min = 1, max = 8)
    private String dni;

    @Size(min = 1, max = 20)
    private String nombre;

    @Size(min = 1, max = 20)
    private String apPaterno;

    @Size(min = 1, max = 20)
    private String apMaterno;

    @NotNull()
    private boolean genero;

    @NotNull()
    private EstadoCivil estadoCivil;

    @NotNull()
    private LocalDate fechaNacimiento;

    @Size(min = 1, max = 30)
    private String foto;

    public InsertarEmpleadoRequest() {
    }

    public @Size(min = 1, max = 6) String getCod() {
        return this.cod;
    }

    public @Size(min = 1, max = 8) String getDni() {
        return this.dni;
    }

    public @Size(min = 1, max = 20) String getNombre() {
        return this.nombre;
    }

    public @Size(min = 1, max = 20) String getApPaterno() {
        return this.apPaterno;
    }

    public @Size(min = 1, max = 20) String getApMaterno() {
        return this.apMaterno;
    }

    public @NotNull() boolean isGenero() {
        return this.genero;
    }

    public @NotNull() EstadoCivil getEstadoCivil() {
        return this.estadoCivil;
    }

    public @NotNull() LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public @Size(min = 1, max = 30) String getFoto() {
        return this.foto;
    }

    public void setCod(@Size(min = 1, max = 6) String cod) {
        this.cod = cod;
    }

    public void setDni(@Size(min = 1, max = 8) String dni) {
        this.dni = dni;
    }

    public void setNombre(@Size(min = 1, max = 20) String nombre) {
        this.nombre = nombre;
    }

    public void setApPaterno(@Size(min = 1, max = 20) String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public void setApMaterno(@Size(min = 1, max = 20) String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public void setGenero(@NotNull() boolean genero) {
        this.genero = genero;
    }

    public void setEstadoCivil(@NotNull() EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setFechaNacimiento(@NotNull() LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFoto(@Size(min = 1, max = 30) String foto) {
        this.foto = foto;
    }
}
