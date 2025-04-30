package com.unu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jorandaslaborales")
public class JornadasLaborale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="JLabCodigo")
	private int jLabCodigo;
	@Column(name="Nombre",unique = true, length =20)
	private String nombre;

	

	public JornadasLaborale() {
		super();
	}

	public JornadasLaborale(int jLabCodigo, String nombre) {
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
