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
@Table(name = "modalidadescontrato")
public class ModalidadesContrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdModalidad")
	private int idModalidad;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdTipoModalidad", foreignKey = @ForeignKey(name = "fk_modalidad_tipomodalidad"))
	private TipoModalidad tipomodalidad;
	
	@Column(name="FechaInicio")
	private LocalDate fechaInicio;
	@Column(name="FechaFin")
	private LocalDate fechaFin;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdEmpleado", foreignKey = @ForeignKey(name = "fk_modalidad_empleado"))
	private Empleado empleado;

	public ModalidadesContrato() {
		super();
	}

	public int getIdModalidad() {
		return idModalidad;
	}

	public void setIdModalidad(int idModalidad) {
		this.idModalidad = idModalidad;
	}

	public TipoModalidad getTipomodalidad() {
		return tipomodalidad;
	}

	public void setTipomodalidad(TipoModalidad tipomodalidad) {
		this.tipomodalidad = tipomodalidad;
	}

	public ModalidadesContrato(int idModalidad, TipoModalidad tipomodalidad, LocalDate fechaInicio, LocalDate fechaFin,
			Empleado empleado) {
		super();
		this.idModalidad = idModalidad;
		this.tipomodalidad = tipomodalidad;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.empleado = empleado;
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

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
