package com.unu.service;

import java.util.List;

import com.unu.entity.Facturacion;

public interface FacturacionService {
	public abstract List<Facturacion> listAllFact(String fact);
	public abstract Facturacion addFact(Facturacion fact);
	public abstract Facturacion getFact(long	id)throws Exception;
	public abstract void updatefact(Facturacion fact);
	public abstract void deletefact(long id);
}
