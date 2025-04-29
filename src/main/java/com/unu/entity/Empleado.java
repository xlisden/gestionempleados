package com.unu.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
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
public class Empleado {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdEmpleado")
	private int idEmpleado;
	@Column(name="EmpleadoCod",unique = true, length =10)
	private String empleadoCod;
	@Column(name="Dni",unique = true, length =8)
	private String dni;
	@Column(name="Nombres",length =20)
	private String nombres;
	@Column(name="ApPaterno",length =15)
	private String apPaterno;
	@Column(name="ApMaterno",length =15)
	private String apMaterno;
	@Column(name="Genero")
	private boolean genero;
	@Column(name="Estado")
	private boolean estado;
	@Column(name="FechaNaci")
	private LocalDate fechaNaci;
	@Column(name="Foto",unique = true, length =30)
	private String foto;
	@Column(name="FechaIngreso")
	private LocalDate fechaIngreso;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdArea", foreignKey = @ForeignKey(name = "fk_empleado_area"))
	private Area area;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "JLabCodigo", foreignKey = @ForeignKey(name = "fk_empleado_jornada"))
	private JornadasLaborale jornada;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EstCivilCod", foreignKey = @ForeignKey(name = "fk_empleado_estadoc"))
	private EstadosCivile estadoC;

	public Empleado() {
		super();
	}
	
	

	public Empleado(int idEmpleado, String empleadoCod, String dni, String nombres, String apPaterno, String apMaterno,
			boolean genero, boolean estado, LocalDate fechaNaci, String foto, LocalDate fechaIngreso, Area area,
			JornadasLaborale jornada, EstadosCivile estadoC) {
		super();
		this.idEmpleado = idEmpleado;
		this.empleadoCod = empleadoCod;
		this.dni = dni;
		this.nombres = nombres;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.genero = genero;
		this.estado = estado;
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


	public boolean isGenero() {
		return genero;
	}



	public void setGenero(boolean genero) {
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public JornadasLaborale getJornada() {
		return jornada;
	}

	public void setJornada(JornadasLaborale jornada) {
		this.jornada = jornada;
	}

	public EstadosCivile getEstadoC() {
		return estadoC;
	}

	public void setEstadoC(EstadosCivile estadoC) {
		this.estadoC = estadoC;
	}

	
}
