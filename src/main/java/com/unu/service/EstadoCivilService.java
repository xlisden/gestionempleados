package com.unu.service;

import com.unu.entity.EstadoCivil;

import java.util.List;

public interface EstadoCivilService {
    public abstract List<EstadoCivil> listAllEstados();

    public abstract EstadoCivil addEstados(EstadoCivil estado);

    public abstract EstadoCivil getEstados(long id) throws Exception;

    public abstract void updateEstado(EstadoCivil estado);

    public abstract void deleteEstado(long id);
}
