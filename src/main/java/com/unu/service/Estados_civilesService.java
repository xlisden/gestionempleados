package com.unu.service;

import java.util.List;


import com.unu.entity.Estados_civiles;

public interface Estados_civilesService {
	public abstract List<Estados_civiles> listAllEstados(String estado);
	public abstract Estados_civiles addEstados(Estados_civiles estado);
	public abstract Estados_civiles getEstados(long	id)throws Exception;
	public abstract void updateestado(Estados_civiles estado);
	public abstract void deleteestado(long id);
}
