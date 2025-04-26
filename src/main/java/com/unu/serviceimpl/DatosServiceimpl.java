package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.Datos_bancarios;
import com.unu.repository.Datos_bancariosRepository;
import com.unu.service.Datos_bancariosService;

@Service("datosservice")
public class DatosServiceimpl implements Datos_bancariosService {
	
	@Autowired
	@Qualifier("datosrepository")
	private Datos_bancariosRepository datosrepo;

	@Override
	public List<Datos_bancarios> listAllDatos(String datos) {
		// TODO Auto-generated method stub
		return datosrepo.findAll();
	}

	@Override
	public Datos_bancarios addDatos(Datos_bancarios datos) {
		return datosrepo.save(datos);
	}

	@Override
	public Datos_bancarios getDatos(long id) throws Exception {
		return datosrepo.findById(id).orElseThrow(() -> new Exception("Los Datos banc para editar no existe"));
	}

	@Override
	public void updatedatos(Datos_bancarios datos) {
		datosrepo.save(datos);
	}

	@Override
	public void deletedatos(long id) {
		datosrepo.deleteById(id);
	}
	
	
	
	
	
}
