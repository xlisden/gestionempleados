package com.unu.service;

import com.unu.entity.Contrato;

import java.util.List;

public interface ContratoService {

    public abstract List<Contrato> listAllContratos();

    public abstract Contrato addTipoM(Contrato contrato);

    public abstract Contrato getTipoM(long id) throws Exception;

    public abstract void updateTipoM(Contrato contrato);

    public abstract void deleteTipoM(long id);

    public abstract Contrato findByEmpleado(int idEmpleado);

}
