package com.unu.service;

import java.util.List;

import com.unu.entity.Datos_bancarios;

public interface Datos_bancariosService {
	
	public abstract List<Datos_bancarios> listAllDatos(String datos);
	public abstract Datos_bancarios addDatos(Datos_bancarios datos);
	public abstract Datos_bancarios getDatos(long	id)throws Exception;
	public abstract void updatedatos(Datos_bancarios datos);
	public abstract void deletedatos(long id);
}
