package com.unu.service;

import java.util.List;

import com.unu.entity.JornadaLaboral;

public interface JornadaService {
	public abstract List<JornadaLaboral> listAllJornada(String jord);
	public abstract JornadaLaboral addJord(JornadaLaboral jord);
	public abstract JornadaLaboral getJord(long	id)throws Exception;
	public abstract void updateJord(JornadaLaboral jord);
	public abstract void deleteJord(long id);
}
