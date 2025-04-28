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
	private int idEmpleado;
	private String empleadoCod;
	private String dni;
	private String nombres;
	private String apPaterno;
	private String apMaterno;
	private int genero;
	private boolean estado;
	private LocalDate fechaNaci;
	private String foto;
	private LocalDate fechaIngreso;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idArea", foreignKey = @ForeignKey(name = "fk_empleado_area"))
	private Areas area;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "jLabCodigo", foreignKey = @ForeignKey(name = "fk_empleado_jornada"))
	private JornadasLaborales jornada;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estCivilCod", foreignKey = @ForeignKey(name = "fk_empleado_estadoc"))
	private EstadosCiviles estadoC;

	public Empleados() {
		super();
	}

	public Empleados(int idEmpleado, String empleadoCod, String dni, String nombres, String apPaterno, String apMaterno,
			int genero, boolean estado, LocalDate fechaNaci, String foto, LocalDate fechaIngreso, Areas area,
			JornadasLaborales jornada, EstadosCiviles estadoC) {
		super();
		this.idEmpleado = idEmpleado;
		this.empleadoCod = empleadoCod;
		this.dni = dni;
		this.nombres = nombres;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.genero = genero;
		this.estado = true;
		this.fechaNaci = fechaNaci;
		if(foto==null)
			this.foto = "ddd.png";
		else
			this.foto=foto;
		this.fechaIngreso = fechaIngreso;
		this.area = area;
		this.jornada = jornada;
		this.estadoC = estadoC;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getEmpleadoCod() {
		return empleadoCod;
	}

	public void setEmpleadoCod(String empleadoCod) {
		this.empleadoCod = empleadoCod;
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

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public LocalDate getFechaNaci() {
		return fechaNaci;
	}

	public void setFechaNaci(LocalDate fechaNaci) {
		this.fechaNaci = fechaNaci;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Areas getArea() {
		return area;
	}

	public void setArea(Areas area) {
		this.area = area;
	}

	public JornadasLaborales getJornada() {
		return jornada;
	}

	public void setJornada(JornadasLaborales jornada) {
		this.jornada = jornada;
	}

	public EstadosCiviles getEstadoC() {
		return estadoC;
	}

	public void setEstadoC(EstadosCiviles estadoC) {
		this.estadoC = estadoC;
	}

	
}
