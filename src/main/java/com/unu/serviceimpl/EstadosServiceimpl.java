package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.Estados_civiles;
import com.unu.repository.Estados_civilesRepository;
import com.unu.service.Estados_civilesService;

@Service("estadosservice")
public class EstadosServiceimpl implements Estados_civilesService {
	@Autowired
	@Qualifier("estadosrepository")
	private Estados_civilesRepository estadosrepo;

	@Override
	public List<Estados_civiles> listAllEstados(String estado) {
		// TODO Auto-generated method stub
		return estadosrepo.findAll();
	}

	@Override
	public Estados_civiles addEstados(Estados_civiles estado) {
		return estadosrepo.save(estado);
	}

	@Override
	public Estados_civiles getEstados(long id) throws Exception {
		return estadosrepo.findById(id).orElseThrow(() -> new Exception("El Estado civ para editar no existe"));
	}

	@Override
	public void updateestado(Estados_civiles estado) {
		estadosrepo.save(estado);
	}

	@Override
	public void deleteestado(long id) {
		estadosrepo.deleteById(id);
	}
	
	
	
	
	
	
}
