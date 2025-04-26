package com.unu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jorandas_laborales")
public class Jornadas_laborales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int j_lab_codigo;
	private String nombre;

	public Jornadas_laborales(int j_lab_codigo, String nombre) {
		super();
		this.j_lab_codigo = j_lab_codigo;
		this.nombre = nombre;
	}

	public Jornadas_laborales() {
		super();
	}

	public int getJ_lab_codigo() {
		return j_lab_codigo;
	}

	public void setJ_lab_codigo(int j_lab_codigo) {
		this.j_lab_codigo = j_lab_codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
