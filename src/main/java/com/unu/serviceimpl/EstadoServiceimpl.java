package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.EstadosCivile;
import com.unu.repository.EstadosCivileRepository;
import com.unu.service.EstadosCivileService;

@Service("estadosservice")
public class EstadoServiceimpl implements EstadosCivileService {
	@Autowired
	@Qualifier("estadosrepository")
	private EstadosCivileRepository estadosrepo;

	@Override
	public List<EstadosCivile> listAllEstados(String estado) {
		// TODO Auto-generated method stub
		return estadosrepo.findAll();
	}

	@Override
	public EstadosCivile addEstados(EstadosCivile estado) {
		return estadosrepo.save(estado);
	}

	@Override
	public EstadosCivile getEstados(long id) throws Exception {
		return estadosrepo.findById(id).orElseThrow(() -> new Exception("El Estado civ para editar no existe"));
	}

	@Override
	public void updateEstado(EstadosCivile estado) {
		estadosrepo.save(estado);
	}

	@Override
	public void deleteEstado(long id) {
		estadosrepo.deleteById(id);
	}
	
	
	
	
	
	
}
