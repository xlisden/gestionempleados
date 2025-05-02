package com.unu.entity;


//<editor-fold defaultstate="collapsed" desc=" Librerías...">

import jakarta.persistence.*;

import java.time.LocalDate;
//</editor-fold>

@Entity
@Table(name = "Empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmpId")
    private int id;

    @Column(name = "EmpCod", unique = true, length = 6)
    private String cod;

    @Column(name = "EmpDni", unique = true, length = 8)
    private String dni;

    @Column(name = "EmpNombre", length = 50)
    private String nombre;

    @Column(name = "EmpApPaterno", length = 20)
    private String apPaterno;

    @Column(name = "EmpApMaterno", length = 20)
    private String apMaterno;

    @Column(name = "EmpGenero")
    private boolean genero;

    @ManyToOne
    @JoinColumn(name = "EmpEstadoCivil", foreignKey = @ForeignKey(name = "fk_empleado_estado_civil"))
    private EstadoCivil estadoCivil;

    @Column(name = "EmpFechaNac")
    private LocalDate fechaNac;

    @Column(name = "EmpFoto", length = 30)
    private String foto;

    @Column(name = "EmpActivo")
    private boolean activo;

    public Empleado() {
    }

    public Empleado(int id, String cod, String dni, String nombre, String apPaterno, String apMaterno, boolean genero, EstadoCivil estadoCivil, LocalDate fechaNac, String foto, boolean activo) {
        this.id = id;
        this.cod = cod;
        this.dni = dni;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.fechaNac = fechaNac;
        this.foto = foto;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNacimiento) {
        this.fechaNac = fechaNacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
