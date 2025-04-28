package com.unu.service;

import java.util.List;

import com.unu.entity.Jornadas_laborales;

public interface JornadasService {
	public abstract List<Jornadas_laborales> listAllJornada(String jord);
	public abstract Jornadas_laborales addJord(Jornadas_laborales jord);
	public abstract Jornadas_laborales getJord(long	id)throws Exception;
	public abstract void updatejord(Jornadas_laborales jord);
	public abstract void deletejord(long id);
}
