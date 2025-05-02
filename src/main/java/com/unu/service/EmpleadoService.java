package com.unu.service;

import com.unu.entity.Empleado;
import com.unu.entity.dto.ContratoDto;
import com.unu.entity.dto.CuentaBancariaDto;
import com.unu.entity.dto.EmpleadoDetalleDto;
import com.unu.entity.dto.EmpleadoDto;

import java.util.List;

public interface EmpleadoService {

    public abstract List<EmpleadoDto> listAllEmpleados();

    public abstract Empleado addEmple(Empleado emple);

    public abstract EmpleadoDetalleDto getEmpleado(int id) throws Exception;

    public abstract void updateEmple(Empleado emple);

    public abstract void deleteEmple(long id);

    public abstract CuentaBancariaDto getCuentaBancaria(int id) throws Exception;

    public abstract ContratoDto getContrato(int id) throws Exception;

    public abstract boolean dniExists(String dni);

    public abstract void desactivar(int id);
}
