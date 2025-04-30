package com.unu.service;

import java.util.List;

import com.unu.entity.CuentaBancaria;

public interface CuentaBancariaService {
	
	public abstract List<CuentaBancaria> listAllCuentas();
	public abstract CuentaBancaria addDatos(CuentaBancaria cuenta);
	public abstract CuentaBancaria getDatos(long id)throws Exception;
	public abstract void updateDatos(CuentaBancaria cuenta);
	public abstract void deleteDatos(long id);
	public abstract CuentaBancaria getByEmpleado(int id)throws Exception;

}
