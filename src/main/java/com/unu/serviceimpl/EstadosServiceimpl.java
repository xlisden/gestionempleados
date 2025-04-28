package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.EstadosCiviles;
import com.unu.repository.EstadosCivilesRepository;
import com.unu.service.EstadosCivilesService;

@Service("estadosservice")
public class EstadosServiceimpl implements EstadosCivilesService {
	@Autowired
	@Qualifier("estadosrepository")
	private EstadosCivilesRepository estadosrepo;

	@Override
	public List<EstadosCiviles> listAllEstados(String estado) {
		// TODO Auto-generated method stub
		return estadosrepo.findAll();
	}

	@Override
	public EstadosCiviles addEstados(EstadosCiviles estado) {
		return estadosrepo.save(estado);
	}

	@Override
	public EstadosCiviles getEstados(long id) throws Exception {
		return estadosrepo.findById(id).orElseThrow(() -> new Exception("El Estado civ para editar no existe"));
	}

	@Override
	public void updateEstado(EstadosCiviles estado) {
		estadosrepo.save(estado);
	}

	@Override
	public void deleteEstado(long id) {
		estadosrepo.deleteById(id);
	}
	
	
	
	
	
	
}
