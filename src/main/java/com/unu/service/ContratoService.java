package com.unu.service;

import java.util.List;

import com.unu.entity.Contrato;

public interface ContratoService {

	public abstract List<Contrato> listAllContratos();
	public abstract Contrato addTipoM(Contrato contrato);
	public abstract Contrato getTipoM(long	id)throws Exception;
	public abstract void updateTipoM(Contrato contrato);
	public abstract void deleteTipoM(long id);

}
