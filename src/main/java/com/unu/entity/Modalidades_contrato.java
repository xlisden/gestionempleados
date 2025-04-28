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
@Table(name="modalidades_contrato")
public class Modalidades_contrato {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_modalidad;
	private String mod_cambio_cod;
	private LocalDate fecha_inicio;
	private LocalDate fecha_fin;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_empleado", foreignKey = @ForeignKey(name = "fk_modalidad_empleado"))
	private Empleados empleado;

	public Modalidades_contrato() {
		super();
	}

	

	public int getId_modalidad() {
		return id_modalidad;
	}



	public void setId_modalidad(int id_modalidad) {
		this.id_modalidad = id_modalidad;
	}



	public Modalidades_contrato(int id_modalidad, String mod_cambio_cod, LocalDate fecha_inicio, LocalDate fecha_fin,
			Empleados empleado) {
		super();
		this.id_modalidad = id_modalidad;
		this.mod_cambio_cod = mod_cambio_cod;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.empleado = empleado;
	}



	public String getMod_cambio_cod() {
		return mod_cambio_cod;
	}

	public void setMod_cambio_cod(String mod_cambio_cod) {
		this.mod_cambio_cod = mod_cambio_cod;
	}

	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public LocalDate getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(LocalDate fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}
	
	
}
