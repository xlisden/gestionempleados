package com.unu.service;

import com.unu.entity.JornadaLaboral;

import java.util.List;

public interface JornadaLaboralService {
	public abstract List<JornadaLaboral> listAllJornadas();

	public abstract JornadaLaboral addJord(JornadaLaboral jord);

	public abstract JornadaLaboral getJord(long id) throws Exception;

	public abstract void updateJord(JornadaLaboral jord);

	public abstract void deleteJord(long id);
}
