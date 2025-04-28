package com.unu.service;

import java.util.List;

import com.unu.entity.DatosBancarios;

public interface DatosBancariosService {
	
	public abstract List<DatosBancarios> listAllDatos(String datos);
	public abstract DatosBancarios addDatos(DatosBancarios datos);
	public abstract DatosBancarios getDatos(long	id)throws Exception;
	public abstract void updateDatos(DatosBancarios datos);
	public abstract void deleteDatos(long id);
}
