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
public class Facturacion {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int facturacion_cod;
	private LocalDate fecha_pago;
	private double sueldo_neto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_empleado", foreignKey = @ForeignKey(name = "fk_facturacion_empleado"))
	private Empleados empleado;

	public Facturacion() {
		super();
	}

	public Facturacion(int facturacion_cod, LocalDate fecha_pago, double sueldo_neto, Empleados empleado) {
		super();
		this.facturacion_cod = facturacion_cod;
		this.fecha_pago = fecha_pago;
		this.sueldo_neto = sueldo_neto;
		this.empleado = empleado;
	}

	public int getFacturacion_cod() {
		return facturacion_cod;
	}

	public void setFacturacion_cod(int facturacion_cod) {
		this.facturacion_cod = facturacion_cod;
	}

	public LocalDate getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(LocalDate fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	public double getSueldo_neto() {
		return sueldo_neto;
	}

	public void setSueldo_neto(double sueldo_neto) {
		this.sueldo_neto = sueldo_neto;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}
	
	
}
