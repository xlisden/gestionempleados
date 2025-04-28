package com.unu.service;

import java.util.List;

import com.unu.entity.JornadasLaborales;

public interface JornadasService {
	public abstract List<JornadasLaborales> listAllJornada(String jord);
	public abstract JornadasLaborales addJord(JornadasLaborales jord);
	public abstract JornadasLaborales getJord(long	id)throws Exception;
	public abstract void updateJord(JornadasLaborales jord);
	public abstract void deleteJord(long id);
}
