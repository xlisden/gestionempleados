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
@Table(name="datosbancarios")
public class DatosBancarios {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCuenta;
	private String entidadBancaria;
	private double cci;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEmpleado", foreignKey = @ForeignKey(name = "fk_Datos_empleado"))
	private Empleados empleado;

	public DatosBancarios() {
		super();
	}

	public DatosBancarios(int idCuenta, String entidadBancaria, double cci, Empleados empleado) {
		super();
		this.idCuenta = idCuenta;
		this.entidadBancaria = entidadBancaria;
		this.cci = cci;
		this.empleado = empleado;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getEntidadBancaria() {
		return entidadBancaria;
	}

	public void setEntidadBancaria(String entidadBancaria) {
		this.entidadBancaria = entidadBancaria;
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
