package com.unu.service;

import java.util.List;

import com.unu.entity.TipoModalidad;

public interface TipoModalidadService {

	public abstract List<TipoModalidad> listAllTipoM(String tipom);
	public abstract TipoModalidad addTipoM(TipoModalidad tipom);
	public abstract TipoModalidad getTipoM(long	id)throws Exception;
	public abstract void updateTipoM(TipoModalidad tipom);
	public abstract void deleteTipoM(long id);

}
