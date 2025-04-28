package com.unu.service;

import java.util.List;


import com.unu.entity.EstadosCiviles;

public interface EstadosCivilesService {
	public abstract List<EstadosCiviles> listAllEstados(String estado);
	public abstract EstadosCiviles addEstados(EstadosCiviles estado);
	public abstract EstadosCiviles getEstados(long	id)throws Exception;
	public abstract void updateEstado(EstadosCiviles estado);
	public abstract void deleteEstado(long id);
}
