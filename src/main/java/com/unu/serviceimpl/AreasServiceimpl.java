package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.Areas;
import com.unu.repository.AreaRepository;
import com.unu.service.AreaService;

@Service("areaservice")
public class AreasServiceimpl implements AreaService {

	@Autowired
	@Qualifier("arearepository")
	private AreaRepository arearepo;
	
	@Override
	public List<Areas> listAllAreas(String area) {
		// TODO Auto-generated method stub
		return arearepo.findAll();
	}

	@Override
	public Areas addArea(Areas area) {
		return arearepo.save(area);
	}

	@Override
	public Areas getArea(long id) throws Exception {
		return arearepo.findById(id).orElseThrow(() -> new Exception("El Area para editar no existe"));
	}

	@Override
	public void updatearea(Areas area) {
		arearepo.save(area);
	}

	@Override
	public void deletearea(long id) {
		arearepo.deleteById(id);
	}

}
