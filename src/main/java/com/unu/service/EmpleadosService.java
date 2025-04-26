package com.unu.service;

import java.util.List;

import com.unu.entity.Empleados;

public interface EmpleadosService {
	public abstract List<Empleados> listAllEmpleados(String emple);
	public abstract Empleados addEmple(Empleados emple);
	public abstract Empleados getEmple(long	id)throws Exception;
	public abstract void updateemple(Empleados emple);
	public abstract void deleteemple(long id);
}
