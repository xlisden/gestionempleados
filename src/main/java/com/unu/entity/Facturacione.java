package com.unu.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
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
public class Facturacione {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FacturacionCod")
	private int facturacionCod;
	@Column(name="FechaPago")
	private LocalDate fechaPago;
	@Column(name="SueldoNeto")
	private double sueldoNeto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdEmpleado", foreignKey = @ForeignKey(name = "fk_facturacion_empleado"))
	private Empleado empleado;

	public Facturacione() {
		super();
	}

	public Facturacione(int facturacionCod, LocalDate fechaPago, double sueldoNeto, Empleado empleado) {
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

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
}
