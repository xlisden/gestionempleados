package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.Empleados;
import com.unu.repository.EmpleadosRepository;
import com.unu.service.EmpleadosService;

@Service("empleadosservice")
public class EmpleadosServiceimpl implements EmpleadosService {
	
	@Autowired
	@Qualifier("empleadorepository")
	private EmpleadosRepository emplerepo;

	@Override
	public List<Empleados> listAllEmpleados(String emple) {
		// TODO Auto-generated method stub
		return emplerepo.findAll();
	}

	@Override
	public Empleados addEmple(Empleados emple) {
		return emplerepo.save(emple);
	}

	@Override
	public Empleados getEmple(long id) throws Exception {
		return emplerepo.findById(id).orElseThrow(() -> new Exception("El Empleado para editar no existe"));
	}

	@Override
	public void updateEmple(Empleados emple) {
		emplerepo.save(emple);
	}

	@Override
	public void deleteEmple(long id) {
		// TODO Auto-generated method stub
		emplerepo.deleteById(id);
	}
	
	
	
	
}	
