package com.unu.service;

import com.unu.controller.request.InsertarEmpleadoRequest;
import com.unu.entity.CuentaBancaria;
import com.unu.entity.Empleado;

import java.util.List;

public interface CuentaBancariaService {

    public abstract List<CuentaBancaria> listAllCuentas();

    public abstract CuentaBancaria addDatos(CuentaBancaria cuenta);

    public abstract CuentaBancaria getDatos(long id) throws Exception;

    public abstract void updateDatos(CuentaBancaria cuenta);

    public abstract void deleteDatos(long id);

    public abstract CuentaBancaria getByEmpleado(int id) throws Exception;

    public abstract boolean cciExists(String cci);
    

}
