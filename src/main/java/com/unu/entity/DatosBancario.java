package com.unu.entity;

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
@Table(name="datosbancarios")
public class DatosBancario {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdCuenta")
	private int idCuenta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdEntidad", foreignKey = @ForeignKey(name = "fk_Datos_entidad"))
	private EntidadBancaria entidadBancaria;
	
	@Column(name="Cci",unique = true, length =20)
	private String cci;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdEmpleado", foreignKey = @ForeignKey(name = "fk_Datos_empleado"))
	private Empleado empleado;

	public DatosBancario() {
		super();
	}

	public DatosBancario(int idCuenta, EntidadBancaria entidadBancaria, String cci, Empleado empleado) {
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

	public EntidadBancaria getEntidadBancaria() {
		return entidadBancaria;
	}

	public void setEntidadBancaria(EntidadBancaria entidadBancaria) {
		this.entidadBancaria = entidadBancaria;
	}

	public String getCci() {
		return cci;
	}

	public void setCci(String cci) {
		this.cci = cci;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
	
	
}
