package com.unu.serviceimpl;

import java.util.List;

import com.unu.entity.EstadoCivil;
import com.unu.repository.EstadoCivilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.service.EstadoCivilService;

@Service("estadosservice")
public class EstadoCivilServiceImpl implements EstadoCivilService {
	@Autowired
	@Qualifier("estadosrepository")
	private EstadoCivilRepository estadosrepo;

	@Override
	public List<EstadoCivil> listAllEstados() {
		return estadosrepo.findAll();
	}

	@Override
	public EstadoCivil addEstados(EstadoCivil estado) {
		return estadosrepo.save(estado);
	}

	@Override
	public EstadoCivil getEstados(long id) throws Exception {
		return estadosrepo.findById(id).orElseThrow(() -> new Exception("El Estado Civil no existe."));
	}

	@Override
	public void updateEstado(EstadoCivil estado) {
		estadosrepo.save(estado);
	}

	@Override
	public void deleteEstado(long id) {
		estadosrepo.deleteById(id);
	}
	
	
	
	
	
	
}
