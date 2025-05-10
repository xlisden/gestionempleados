package com.unu.controller.request;

import com.unu.entity.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class InsertarEmpleadoRequest {

    /* Personal */

//    @Size(min = 1, max = 8)
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

    @NotNull()  //  no se ingreo  
    private LocalDate fechaInicio;

    @NotNull()
    private Area area;

    @NotNull()
    private JornadaLaboral jornadaLaboral;

    private LocalDate fechaFin;

    /* Bancario */

    @NotNull()
    private Banco banco;

    @Size(min = 1, max = 20)
    private String cci;


    public InsertarEmpleadoRequest() {
    }

    public String getDni() {
        return this.dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApPaterno() {
        return this.apPaterno;
    }

    public String getApMaterno() {
        return this.apMaterno;
    }

    public boolean isGenero() {
        return this.genero;
    }

    public EstadoCivil getEstadoCivil() {
        return this.estadoCivil;
    }

    public LocalDate getFechaNacimiento() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        return this.fechaNacimiento;
    }

    public String getFoto() {
        return this.foto;
    }

    public LocalDate getFechaEmision() {
        return this.fechaEmision;
    }

    public ModalidadContrato getModalidadContrato() {
        return this.modalidadContrato;
    }

    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }

    public Area getArea() {
        return this.area;
    }

    public JornadaLaboral getJornadaLaboral() {
        return this.jornadaLaboral;
    }

    public Banco getBanco() {
        return this.banco;
    }

    public String getCci() {
        return this.cci;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setModalidadContrato(ModalidadContrato modalidadContrato) {
        this.modalidadContrato = modalidadContrato;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setJornadaLaboral(JornadaLaboral jornadaLaboral) {
        this.jornadaLaboral = jornadaLaboral;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void setCci(String cci) {
        this.cci = cci;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}
