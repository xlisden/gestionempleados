package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.DatosBancarios;
import com.unu.repository.DatosBancariosRepository;
import com.unu.service.DatosBancariosService;

@Service("datosservice")
public class DatosServiceimpl implements DatosBancariosService {
	
	@Autowired
	@Qualifier("datosrepository")
	private DatosBancariosRepository datosrepo;

	@Override
	public List<DatosBancarios> listAllDatos(String datos) {
		// TODO Auto-generated method stub
		return datosrepo.findAll();
	}

	@Override
	public DatosBancarios addDatos(DatosBancarios datos) {
		return datosrepo.save(datos);
	}

	@Override
	public DatosBancarios getDatos(long id) throws Exception {
		return datosrepo.findById(id).orElseThrow(() -> new Exception("Los Datos banc para editar no existe"));
	}

	@Override
	public void updateDatos(DatosBancarios datos) {
		datosrepo.save(datos);
	}

	@Override
	public void deleteDatos(long id) {
		datosrepo.deleteById(id);
	}
	
	
	
	
	
}
