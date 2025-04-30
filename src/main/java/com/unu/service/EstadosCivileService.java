package com.unu.service;

import java.util.List;


import com.unu.entity.EstadosCivile;

public interface EstadosCivileService {
	public abstract List<EstadosCivile> listAllEstados(String estado);
	public abstract EstadosCivile addEstados(EstadosCivile estado);
	public abstract EstadosCivile getEstados(long	id)throws Exception;
	public abstract void updateEstado(EstadosCivile estado);
	public abstract void deleteEstado(long id);
}
