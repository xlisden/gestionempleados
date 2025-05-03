package com.unu.controller.request;

import com.unu.entity.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class EditarEmpleadoRequest {

    /* Personal */

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

    /* Laboral */

    @NotNull()
    private LocalDate fechaEmision;

    @NotNull()
    private ModalidadContrato modalidadContrato;

    @NotNull()
    private LocalDate fechaInicio;

    @NotNull()
    private Area area;

    @NotNull()
    private JornadaLaboral jornadaLaboral;

    /* Bancario */

    @NotNull()
    private Banco banco;

    @Size(min = 1, max = 20)
    private String cci;

    public EditarEmpleadoRequest() {
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

    public @NotNull() LocalDate getFechaEmision() {
        return this.fechaEmision;
    }

    public @NotNull() ModalidadContrato getModalidadContrato() {
        return this.modalidadContrato;
    }

    public @NotNull() LocalDate getFechaInicio() {
        return this.fechaInicio;
    }

    public @NotNull() Area getArea() {
        return this.area;
    }

    public @NotNull() JornadaLaboral getJornadaLaboral() {
        return this.jornadaLaboral;
    }

    public @NotNull() Banco getBanco() {
        return this.banco;
    }

    public @Size(min = 1, max = 20) String getCci() {
        return this.cci;
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

    public void setFechaEmision(@NotNull() LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setModalidadContrato(@NotNull() ModalidadContrato modalidadContrato) {
        this.modalidadContrato = modalidadContrato;
    }

    public void setFechaInicio(@NotNull() LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setArea(@NotNull() Area area) {
        this.area = area;
    }

    public void setJornadaLaboral(@NotNull() JornadaLaboral jornadaLaboral) {
        this.jornadaLaboral = jornadaLaboral;
    }

    public void setBanco(@NotNull() Banco banco) {
        this.banco = banco;
    }

    public void setCci(@Size(min = 1, max = 20) String cci) {
        this.cci = cci;
    }
}
