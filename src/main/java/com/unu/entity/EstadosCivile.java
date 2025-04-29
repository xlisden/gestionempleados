package com.unu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estadosciviles")
public class EstadosCivile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EstCivilCod")
	private int estCivilCod;
	@Column(name="Nombre",unique = true, length =10)
	private String nombre;

	public EstadosCivile() {
		super();
	}

	
	public EstadosCivile(int estCivilCod, String nombre) {
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
