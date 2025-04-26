package com.unu.service;

import java.util.List;

import com.unu.entity.Modalidades_contrato;

public interface ModalidadesService {
	public abstract List<Modalidades_contrato> listAllModali(String moda);
	public abstract Modalidades_contrato addmoda(Modalidades_contrato moda);
	public abstract Modalidades_contrato getmoda(long	id)throws Exception;
	public abstract void updatemoda(Modalidades_contrato moda);
	public abstract void deletemoda(long id);
}
		