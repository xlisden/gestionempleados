package com.unu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="entidadbancaria")
public class EntidadBancaria {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdEntidad")
	private int idEntidad;
	
	@Column(name="Nombre",length = 20)
	private String nombre;

	public EntidadBancaria(int idEntidad, String nombre) {
		super();
		this.idEntidad = idEntidad;
		this.nombre = nombre;
	}

	public EntidadBancaria() {
		super();
	}

	public int getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(int idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
