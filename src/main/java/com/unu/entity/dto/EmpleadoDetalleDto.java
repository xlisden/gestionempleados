package com.unu.entity.dto;

public class EmpleadoDetalleDto {

    private int id;
    private String cod;
    private String dni;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String genero;
    private String estadoCivil;
    private int edad;
    private String estado;
    private String foto;
    private boolean isActivo;

    public EmpleadoDetalleDto() {
    }

    public int getId() {
        return this.id;
    }

    public String getCod() {
        return this.cod;
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

    public String getGenero() {
        return this.genero;
    }

    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    public int getEdad() {
        return this.edad;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCod(String cod) {
        this.cod = cod;
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

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isActivo() {
        return isActivo;
    }

    public void setActivo(boolean activo) {
        isActivo = activo;
    }
}
