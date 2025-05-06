package com.unu.service;

import com.unu.entity.Facturacion;
import com.unu.entity.dto.FacturacionDto;

import java.util.List;

public interface FacturacionService {
    public abstract List<Facturacion> listAllFact();

    public abstract Facturacion addFact(Facturacion fact);

    public abstract Facturacion getFact(long id) throws Exception;

    public abstract void updateFact(Facturacion fact);

    public abstract void deleteFact(long id);

    public abstract List<FacturacionDto> listByEmpleado(int idEmpleado);
}
