package com.unu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="datos_bancarios")
public class Datos_bancarios {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_centa;
	private String entidad_bancaria;
	private double cci;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_empleado", foreignKey = @ForeignKey(name = "fk_Datos_empleado"))
	private Empleados empleado;

	public Datos_bancarios() {
		super();
	}

	public Datos_bancarios(int id_centa, String entidad_bancaria, double cci, Empleados empleado) {
		super();
		this.id_centa = id_centa;
		this.entidad_bancaria = entidad_bancaria;
		this.cci = cci;
		this.empleado = empleado;
	}

	public int getId_centa() {
		return id_centa;
	}

	public void setId_centa(int id_centa) {
		this.id_centa = id_centa;
	}

	public String getEntidad_bancaria() {
		return entidad_bancaria;
	}

	public void setEntidad_bancaria(String entidad_bancaria) {
		this.entidad_bancaria = entidad_bancaria;
	}

	public double getCci() {
		return cci;
	}

	public void setCci(double cci) {
		this.cci = cci;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}
	
	
}
