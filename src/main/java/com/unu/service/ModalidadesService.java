package com.unu.service;

import java.util.List;

import com.unu.entity.ModalidadesContrato;

public interface ModalidadesService {
	public abstract List<ModalidadesContrato> listAllModali(String moda);
	public abstract ModalidadesContrato addModali(ModalidadesContrato moda);
	public abstract ModalidadesContrato getModali(long	id)throws Exception;
	public abstract void updateModali(ModalidadesContrato moda);
	public abstract void deleteModali(long id);
}
		