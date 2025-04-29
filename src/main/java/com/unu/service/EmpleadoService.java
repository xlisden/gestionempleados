package com.unu.service;

import java.util.List;

import com.unu.entity.Empleado;

public interface EmpleadoService {
	public abstract List<Empleado> listAllEmpleados(String emple);
	public abstract Empleado addEmple(Empleado emple);
	public abstract Empleado getEmple(long	id)throws Exception;
	public abstract void updateEmple(Empleado emple);
	public abstract void deleteEmple(long id);
}
