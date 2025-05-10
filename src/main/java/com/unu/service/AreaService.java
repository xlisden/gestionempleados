package com.unu.service;

import com.unu.entity.Area;
import com.unu.entity.dto.EmpleadoDto;

import java.util.List;


public interface AreaService {

    public abstract List<Area> listAllAreas();

    public abstract Area addArea(Area area);

    public abstract Area getArea(long id) throws Exception;

    public abstract void updateArea(Area area);

    public abstract void deleteArea(long id);

    public abstract List<EmpleadoDto> getEmpleadosPorArea(int idArea);
}
