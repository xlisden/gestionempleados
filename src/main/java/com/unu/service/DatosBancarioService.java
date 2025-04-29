package com.unu.service;

import java.util.List;

import com.unu.entity.DatosBancario;

public interface DatosBancarioService {
	
	public abstract List<DatosBancario> listAllDatos(String datos);
	public abstract DatosBancario addDatos(DatosBancario datos);
	public abstract DatosBancario getDatos(long	id)throws Exception;
	public abstract void updateDatos(DatosBancario datos);
	public abstract void deleteDatos(long id);
	public abstract DatosBancario getDatosByEmpleado(int id)throws Exception;
}
