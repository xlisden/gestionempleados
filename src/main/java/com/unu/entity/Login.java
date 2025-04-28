package com.unu.entity;

import java.time.LocalTime;

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
@Table(name = "login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLogin;
	private String usurio;
	private String contraseña;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEmpleado", foreignKey = @ForeignKey(name = "fk_login_empleado"))
	private Empleados empleado;

	private boolean estado;
	private LocalTime horas;

	public Login() {
		super();
	}

	public Login(int idLogin, String usurio, String contraseña, Empleados empleado, boolean estado, LocalTime horas) {
		super();
		this.idLogin = idLogin;
		this.usurio = usurio;
		this.contraseña = contraseña;
		this.empleado = empleado;
		this.estado = estado;
		this.horas = horas;
	}

	public int getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public LocalTime getHoras() {
		return horas;
	}

	public void setHoras(LocalTime horas) {
		this.horas = horas;
	}

	public String getUsurio() {
		return usurio;
	}

	public void setUsurio(String usurio) {
		this.usurio = usurio;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}

}
