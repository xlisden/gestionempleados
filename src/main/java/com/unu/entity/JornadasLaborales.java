package com.unu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jorandaslaborales")
public class JornadasLaborales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jLabCodigo;
	private String nombre;

	

	public JornadasLaborales() {
		super();
	}

	public JornadasLaborales(int jLabCodigo, String nombre) {
		super();
		this.jLabCodigo = jLabCodigo;
		this.nombre = nombre;
	}

	public int getjLabCodigo() {
		return jLabCodigo;
	}

	public void setjLabCodigo(int jLabCodigo) {
		this.jLabCodigo = jLabCodigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
