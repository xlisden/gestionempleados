package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.TipoModalidad;
import com.unu.repository.TipoModalidadRepository;
import com.unu.service.TipoModalidadService;

@Service("tipomodalidadservice")
public class TipoModalidadServiceimpl implements TipoModalidadService{
	@Autowired
	@Qualifier("tipomodalidadrepository")
	private TipoModalidadRepository tipomrepo;

	@Override
	public List<TipoModalidad> listAllTipoM(String tipom) {
		// TODO Auto-generated method stub
		return tipomrepo.findAll();
	}

	@Override
	public TipoModalidad addTipoM(TipoModalidad tipom) {
		return tipomrepo.save(tipom);
	}

	@Override
	public TipoModalidad getTipoM(long id) throws Exception {
		return tipomrepo.findById(id).orElseThrow(() -> new Exception("Los Tipo Moda para editar no existe"));
	}

	@Override
	public void updateTipoM(TipoModalidad tipom) {
		tipomrepo.save(tipom);
	}

	@Override
	public void deleteTipoM(long id) {
		tipomrepo.deleteById(id);
	}
	
	
	
}
