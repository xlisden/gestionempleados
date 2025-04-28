package com.unu.service;

import java.util.List;

import com.unu.entity.Areas;


public interface AreasService {
	
	public abstract List<Areas> listAllAreas(String area);
	public abstract Areas addArea(Areas area);
	public abstract Areas getArea(long	id)throws Exception;
	public abstract void updateArea(Areas area);
	public abstract void deleteArea(long id);
}
