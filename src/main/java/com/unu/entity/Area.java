package com.unu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="areas")
public class Area {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdArea")
	private int idArea;
	@Column(name="AreaCod",unique = true, length =5)
	private String areaCod;
	@Column(name="Nombre",unique = true, length =20)
	private String nombre;
	@Column(name="Salario")
	private double salario;
	
	public Area() {
		super();
	}

	public Area(int idArea, String areaCod, String nombre, double salario) {
		super();
		this.idArea = idArea;
		this.areaCod = areaCod;
		this.nombre = nombre;
		this.salario = salario;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getAreaCod() {
		return areaCod;
	}

	public void setAreaCod(String areaCod) {
		this.areaCod = areaCod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	
	

	
	
}
