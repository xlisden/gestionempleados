package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.Empleado;
import com.unu.repository.EmpleadoRepository;
import com.unu.service.EmpleadoService;

@Service("empleadosservice")
public class EmpleadoServiceimpl implements EmpleadoService {
	
	@Autowired
	@Qualifier("empleadorepository")
	private EmpleadoRepository emplerepo;

	@Override
	public List<Empleado> listAllEmpleados(String emple) {
		// TODO Auto-generated method stub
		return emplerepo.findAll();
	}

	@Override
	public Empleado addEmple(Empleado emple) {
		return emplerepo.save(emple);
	}

	@Override
	public Empleado getEmple(long id) throws Exception {
		return emplerepo.findById(id).orElseThrow(() -> new Exception("El Empleado no existe."));
	}

	@Override
	public void updateEmple(Empleado emple) {
		emplerepo.save(emple);
	}

	@Override
	public void deleteEmple(long id) {
		// TODO Auto-generated method stub
		emplerepo.deleteById(id);
	}
	
	
	
	
}	
