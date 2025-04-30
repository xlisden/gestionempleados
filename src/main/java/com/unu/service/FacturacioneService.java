package com.unu.service;

import java.util.List;

import com.unu.entity.Facturacione;

public interface FacturacioneService {
	public abstract List<Facturacione> listAllFact(String fact);
	public abstract Facturacione addFact(Facturacione fact);
	public abstract Facturacione getFact(long	id)throws Exception;
	public abstract void updateFact(Facturacione fact);
	public abstract void deleteFact(long id);
}
