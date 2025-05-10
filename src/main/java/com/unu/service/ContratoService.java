package com.unu.service;

import com.unu.controller.request.ContratoRequest;
import com.unu.entity.Contrato;

import java.util.List;

public interface ContratoService {

    public abstract List<Contrato> listAllContratos();

    public abstract Contrato addContrato(ContratoRequest request);

    public abstract Contrato addTipoM(Contrato contrato);

    public abstract Contrato getTipoM(long id) throws Exception;

    public abstract void updateContrato(Contrato contrato);

    public abstract void deleteTipoM(long id);

    public abstract Contrato findByEmpleado(int idEmpleado);

//    public abstract ContratoRequest findByEmpleadoRequest(int idEmpleado) throws Exception;
    public abstract boolean contratoIsActivo(int idEmpleado);

    public abstract void desactivar(int id);

//    public abstract void activar(int id);

}
