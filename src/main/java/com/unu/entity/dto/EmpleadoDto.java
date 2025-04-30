package com.unu.entity.dto;

public class EmpleadoDto {

    private int id;
    private String cod;
    private String dni;
    private String nombreCompleto;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String genero;
    private String area;
    private String modalidadContrato;
    private String jornadaLaboral;
    private String estadoCivil;
    private int edad;
    private String estado;
    private String antiguedad;

    public EmpleadoDto() {
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getModalidadContrato() {
        return modalidadContrato;
    }

    public void setModalidadContrato(String modalidadContrato) {
        this.modalidadContrato = modalidadContrato;
    }

    public String getJornadaLaboral() {
        return jornadaLaboral;
    }

    public void setJornadaLaboral(String jornadaLaboral) {
        this.jornadaLaboral = jornadaLaboral;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return "EmpleadoDto{" +
                "id=" + id +
                ", cod='" + cod + '\'' +
                ", dni='" + dni + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apPaterno='" + apPaterno + '\'' +
                ", apMaterno='" + apMaterno + '\'' +
                ", genero='" + genero + '\'' +
                ", area='" + area + '\'' +
                ", modalidadContrato='" + modalidadContrato + '\'' +
                ", jornadaLaboral='" + jornadaLaboral + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", edad=" + edad +
                ", estado='" + estado + '\'' +
                ", antiguedad='" + antiguedad + '\'' +
                '}';
    }
}
