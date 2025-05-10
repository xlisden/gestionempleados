package com.unu.entity;

//<editor-fold defaultstate="collapsed" desc=" Librerías...">

import jakarta.persistence.*;

import java.time.LocalDate;

//</editor-fold>

@Entity
@Table(name = "Contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ContId")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ContEmpleado", foreignKey = @ForeignKey(name = "fk_contrato_empleado"))
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "ContArea", foreignKey = @ForeignKey(name = "fk_contrato_area"))
    private Area area;

    private LocalDate fechaEmision;

    @ManyToOne
    @JoinColumn(name = "ContModalidadCont", foreignKey = @ForeignKey(name = "fk_contrato_modalidad_cont"))
    private ModalidadContrato modalidadCont;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name = "ContJLaboral", foreignKey = @ForeignKey(name = "fk_contrato_jord_laboral"))
    private JornadaLaboral jornadaLaboral;

    @Column(name = "ContActivo")
    private boolean activo;

    public Contrato() {
    }

    public Contrato(int id, Empleado empleado, Area area, LocalDate fechaEmision, ModalidadContrato modalidadCont, LocalDate fechaInicio, LocalDate fechaFin, JornadaLaboral jornadaLaboral) {
        this.id = id;
        this.empleado = empleado;
        this.area = area;
        this.fechaEmision = fechaEmision;
        this.modalidadCont = modalidadCont;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.jornadaLaboral = jornadaLaboral;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public ModalidadContrato getModalidadCont() {
        return modalidadCont;
    }

    public void setModalidadCont(ModalidadContrato modContrato) {
        this.modalidadCont = modContrato;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public JornadaLaboral getJornadaLaboral() {
        return jornadaLaboral;
    }

    public void setJornadaLaboral(JornadaLaboral jornadaLaboral) {
        this.jornadaLaboral = jornadaLaboral;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id=" + id +
                ", empleado=" + empleado +
                ", area=" + area +
                ", fechaEmision=" + fechaEmision +
                ", modalidadCont=" + modalidadCont +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", jornadaLaboral=" + jornadaLaboral +
                '}';
    }
}
