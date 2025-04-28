package com.unu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="areas")
public class Areas {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_area;
	private String Area_cod;
	private String nombre;
	private double salario;
	
	public Areas() {
		super();
	}

	

	public Areas(int id_area, String area_cod, String nombre, double salario) {
		super();
		this.id_area = id_area;
		Area_cod = area_cod;
		this.nombre = nombre;
		this.salario = salario;
	}



	public String getArea_cod() {
		return Area_cod;
	}

	public void setArea_cod(String area_cod) {
		Area_cod = area_cod;
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



	public int getId_area() {
		return id_area;
	}



	public void setId_area(int id_area) {
		this.id_area = id_area;
	}
	
	
	
}
