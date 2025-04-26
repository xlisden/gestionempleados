package com.unu.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleados {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_empleado;
	private String empleado_cod;
	private String dni;
	private String nombres;
	private String ap_paterno;
	private String ap_materno;
	private int genero;
	private LocalDate fecha_nac;
	private String foto="no_image.png";
	private LocalDate fecha_ingreso;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_area", foreignKey = @ForeignKey(name = "fk_empleado_area"))
	private Areas area;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "j_lab_codigo", foreignKey = @ForeignKey(name = "fk_empleado_jornada"))
	private Jornadas_laborales jornada;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "est_civil_cod", foreignKey = @ForeignKey(name = "fk_empleado_estadoc"))
	private Estados_civiles estado_c;

	public Empleados() {
		super();
	}

	

	public int getId_empleado() {
		return id_empleado;
	}



	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}



	public Empleados(int id_empleado, String empleado_cod, String dni, String nombres, String ap_paterno,
			String ap_materno, int genero, LocalDate fecha_nac, String foto, LocalDate fecha_ingreso, Areas area,
			Jornadas_laborales jornada, Estados_civiles estado_c) {
		super();
		this.id_empleado = id_empleado;
		this.empleado_cod = empleado_cod;
		this.dni = dni;
		this.nombres = nombres;
		this.ap_paterno = ap_paterno;
		this.ap_materno = ap_materno;
		this.genero = genero;
		this.fecha_nac = fecha_nac;
		this.foto = foto;
		this.fecha_ingreso = fecha_ingreso;
		this.area = area;
		this.jornada = jornada;
		this.estado_c = estado_c;
	}



	public String getEmpleado_cod() {
		return empleado_cod;
	}

	public void setEmpleado_cod(String empleado_cod) {
		this.empleado_cod = empleado_cod;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getAp_paterno() {
		return ap_paterno;
	}

	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}

	public String getAp_materno() {
		return ap_materno;
	}

	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public LocalDate getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public LocalDate getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(LocalDate fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Areas getArea() {
		return area;
	}

	public void setArea(Areas area) {
		this.area = area;
	}

	public Jornadas_laborales getJornada() {
		return jornada;
	}

	public void setJornada(Jornadas_laborales jornada) {
		this.jornada = jornada;
	}

	public Estados_civiles getEstado_c() {
		return estado_c;
	}

	public void setEstado_c(Estados_civiles estado_c) {
		this.estado_c = estado_c;
	}
	
	
	
}
