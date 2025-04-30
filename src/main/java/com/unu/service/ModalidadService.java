package com.unu.service;

import java.util.List;

import com.unu.entity.ModalidadContrato;

public interface ModalidadService {
	public abstract List<ModalidadContrato> listAllModali(String moda);
	public abstract ModalidadContrato addModali(ModalidadContrato moda);
	public abstract ModalidadContrato getModali(long	id)throws Exception;
	public abstract void updateModali(ModalidadContrato moda);
	public abstract void deleteModali(long id);
}
		