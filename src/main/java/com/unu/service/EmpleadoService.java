package com.unu.service;

import java.util.List;

import com.unu.entity.Contrato;
import com.unu.entity.Empleado;
import com.unu.entity.dto.ContratoDto;
import com.unu.entity.dto.CuentaBancariaDto;
import com.unu.entity.dto.EmpleadoDto;

public interface EmpleadoService {
	public abstract List<EmpleadoDto> listAllEmpleados();
	public abstract Empleado addEmple(Empleado emple);
	public abstract EmpleadoDto getEmpleado(int id) throws Exception;
	public abstract void updateEmple(Empleado emple);
	public abstract void deleteEmple(long id);

	public abstract CuentaBancariaDto getCuentaBancaria(int id) throws Exception;
	public abstract ContratoDto getContrato(int id) throws Exception;
}
