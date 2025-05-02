package com.unu.service;

import com.unu.entity.ModalidadContrato;

import java.util.List;

public interface ModalidadContratoService {
    public abstract List<ModalidadContrato> listAllModalidades();

    public abstract ModalidadContrato addModalidad(ModalidadContrato moda);

    public abstract ModalidadContrato getModalidad(long id) throws Exception;

    public abstract void updateModali(ModalidadContrato modContrato);

    public abstract void deleteModali(long id);
}
		