package com.unu.service;

import java.util.List;

import com.unu.entity.JornadasLaborale;

public interface JornadaService {
	public abstract List<JornadasLaborale> listAllJornada(String jord);
	public abstract JornadasLaborale addJord(JornadasLaborale jord);
	public abstract JornadasLaborale getJord(long	id)throws Exception;
	public abstract void updateJord(JornadasLaborale jord);
	public abstract void deleteJord(long id);
}
