package com.unu.entity;

import java.time.LocalDate;

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
@Table(name="facturacion")
public class Facturaciones {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int facturacionCod;
	private LocalDate fechaPago;
	private double sueldoNeto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEmpleado", foreignKey = @ForeignKey(name = "fk_facturacion_empleado"))
	private Empleados empleado;

	public Facturaciones() {
		super();
	}

	public Facturaciones(int facturacionCod, LocalDate fechaPago, double sueldoNeto, Empleados empleado) {
		super();
		this.facturacionCod = facturacionCod;
		this.fechaPago = fechaPago;
		this.sueldoNeto = sueldoNeto;
		this.empleado = empleado;
	}

	public int getFacturacionCod() {
		return facturacionCod;
	}

	public void setFacturacionCod(int facturacionCod) {
		this.facturacionCod = facturacionCod;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getSueldoNeto() {
		return sueldoNeto;
	}

	public void setSueldoNeto(double sueldoNeto) {
		this.sueldoNeto = sueldoNeto;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}
	
	
}
