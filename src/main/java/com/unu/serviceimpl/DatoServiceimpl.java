package com.unu.serviceimpl;

import java.util.List;

import com.unu.entity.enums.EstadosCivilesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.DatosBancario;
import com.unu.repository.DatosBancarioRepository;
import com.unu.service.DatosBancarioService;

@Service("datosservice")
public class DatoServiceimpl implements DatosBancarioService {
	
	@Autowired
	@Qualifier("datosrepository")
	private DatosBancarioRepository datosrepo;
 
	
	@Override
	public List<DatosBancario> listAllDatos(String datos) {
		// TODO Auto-generated method stub
		return datosrepo.findAll();
	}

	@Override
	public DatosBancario addDatos(DatosBancario datos) {
		return datosrepo.save(datos);
	}

	@Override
	public DatosBancario getDatos(long id) throws Exception {
		return datosrepo.findById(id).orElseThrow(() -> new Exception("Los Datos banc para editar no existe"));
	}

	@Override
	public void updateDatos(DatosBancario datos) {
		datosrepo.save(datos);
	}

	@Override
	public void deleteDatos(long id) {
		datosrepo.deleteById(id);
	}

	@Override
	public DatosBancario getDatosByEmpleado(int id) throws Exception {
		return datosrepo.findDatosByEmpleado(id);
	}
	
	
	
	
	
}
