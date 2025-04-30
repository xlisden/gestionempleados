package com.unu.service;

import java.util.List;

import com.unu.entity.Area;


public interface AreaService {
	
	public abstract List<Area> listAllAreas();
	public abstract Area addArea(Area area);
	public abstract Area getArea(long	id)throws Exception;
	public abstract void updateArea(Area area);
	public abstract void deleteArea(long id);
}
