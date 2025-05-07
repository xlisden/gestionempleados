package com.unu.controller.request;

import com.unu.entity.Area;
import com.unu.entity.Empleado;
import com.unu.entity.JornadaLaboral;
import com.unu.entity.ModalidadContrato;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class ContratoRequest {

    private Empleado empleado;
    private Area area;
    private JornadaLaboral jornada;
    private ModalidadContrato modalidad;
    private LocalDate fechaEmision;
    private LocalDate fechaInicio;
    private String fechaEmisionValue;
    private String fechaInicioValue;

    public ContratoRequest() {
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public ModalidadContrato getModalidad() {
        return modalidad;
    }

    public void setModalidad(ModalidadContrato modalidad) {
        this.modalidad = modalidad;
    }

    public JornadaLaboral getJornada() {
        return jornada;
    }

    public void setJornada(JornadaLaboral jornada) {
        this.jornada = jornada;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaEmisionValue() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.fechaEmisionValue = format.format(Date.valueOf(LocalDate.now()));
        return fechaEmisionValue;
    }

    public void setFechaEmisionValue(String fechaEmisionValue) {
        this.fechaEmisionValue = fechaEmisionValue;
    }

    public String getFechaInicioValue() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.fechaInicioValue = format.format(Date.valueOf(LocalDate.now()));
        return fechaInicioValue;
    }

    public void setFechaInicioValue(String fechaInicioValue) {
        this.fechaInicioValue = fechaInicioValue;
    }
}
