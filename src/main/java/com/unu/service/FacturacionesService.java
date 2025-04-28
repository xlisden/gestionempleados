package com.unu.service;

import java.util.List;

import com.unu.entity.Facturaciones;

public interface FacturacionesService {
	public abstract List<Facturaciones> listAllFact(String fact);
	public abstract Facturaciones addFact(Facturaciones fact);
	public abstract Facturaciones getFact(long	id)throws Exception;
	public abstract void updateFact(Facturaciones fact);
	public abstract void deleteFact(long id);
}
