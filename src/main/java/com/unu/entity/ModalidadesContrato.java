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
@Table(name="modalidadescontrato")
public class ModalidadesContrato {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idModalidad;
	private String modCambioCod;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEmpleado", foreignKey = @ForeignKey(name = "fk_modalidad_empleado"))
	private Empleados empleado;

	public ModalidadesContrato() {
		super();
	}

	



	public ModalidadesContrato(int idModalidad, String modCambioCod, LocalDate fechaInicio, LocalDate fechaFin,
			Empleados empleado) {
		super();
		this.idModalidad = idModalidad;
		this.modCambioCod = modCambioCod;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.empleado = empleado;
	}





	public int getIdModalidad() {
		return idModalidad;
	}





	public void setIdModalidad(int idModalidad) {
		this.idModalidad = idModalidad;
	}





	public String getModCambioCod() {
		return modCambioCod;
	}





	public void setModCambioCod(String modCambioCod) {
		this.modCambioCod = modCambioCod;
	}





	public LocalDate getFechaInicio() {
		return fechaInicio;
	}





	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}





	public LocalDate getFechaFin() {
		return fechaFin;
	}





	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}





	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}
	
	
}
