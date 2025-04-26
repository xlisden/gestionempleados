package com.unu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estados_civiles")
public class Estados_civiles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int est_civil_cod;
	private String nombre;

	public Estados_civiles() {
		super();
	}

	public Estados_civiles(int est_civil_cod, String nombre) {
		super();
		this.est_civil_cod = est_civil_cod;
		this.nombre = nombre;
	}

	public int getEst_civil_cod() {
		return est_civil_cod;
	}

	public void setEst_civil_cod(int est_civil_cod) {
		this.est_civil_cod = est_civil_cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
