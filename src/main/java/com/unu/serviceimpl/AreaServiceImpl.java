package com.unu.serviceimpl;

import com.unu.entity.Area;
import com.unu.repository.AreaRepository;
import com.unu.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("areaservice")
public class AreaServiceImpl implements AreaService {

    @Autowired
    @Qualifier("arearepository")
    private AreaRepository arearepo;

    @Override
    public List<Area> listAllAreas() {
        return arearepo.findAll();
    }

    @Override
    public Area addArea(Area area) {
        return arearepo.save(area);
    }

    @Override
    public Area getArea(long id) throws Exception {
        return arearepo.findById(id).orElseThrow(() -> new Exception("El Area no existe."));
    }

    @Override
    public void updateArea(Area area) {
        arearepo.save(area);
    }

    @Override
    public void deleteArea(long id) {
        arearepo.deleteById(id);
    }

}
