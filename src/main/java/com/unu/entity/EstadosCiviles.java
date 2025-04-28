package com.unu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estadosciviles")
public class EstadosCiviles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int estCivilCod;
	private String nombre;

	public EstadosCiviles() {
		super();
	}

	
	public EstadosCiviles(int estCivilCod, String nombre) {
		super();
		this.estCivilCod = estCivilCod;
		this.nombre = nombre;
	}


	public int getEstCivilCod() {
		return estCivilCod;
	}


	public void setEstCivilCod(int estCivilCod) {
		this.estCivilCod = estCivilCod;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
