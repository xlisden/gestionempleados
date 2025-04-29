package com.unu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tipomodalidad")
public class TipoModalidad {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdTipoModalidad")
	private int idTipoModalidad;
	@Column(name="Nombre",unique = true, length =20)
	private String nombre;
	public TipoModalidad() {
		super();
	}
	public TipoModalidad(int idTipoModalidad, String nombre) {
		super();
		this.idTipoModalidad = idTipoModalidad;
		this.nombre = nombre;
	}
	public int getIdTipoModalidad() {
		return idTipoModalidad;
	}
	public void setIdTipoModalidad(int idTipoModalidad) {
		this.idTipoModalidad = idTipoModalidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
