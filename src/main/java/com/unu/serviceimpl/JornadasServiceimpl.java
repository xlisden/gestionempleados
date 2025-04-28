package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.JornadasLaborales;
import com.unu.repository.JornadasLaboralesRepository;
import com.unu.service.JornadasService;

@Service("jornadaservice")
public class JornadasServiceimpl implements JornadasService {
	@Autowired
	@Qualifier("jornadasrepository")
	private JornadasLaboralesRepository jordrepo;

	@Override
	public List<JornadasLaborales> listAllJornada(String jord) {
		// TODO Auto-generated method stub
		return jordrepo.findAll();
	}

	@Override
	public JornadasLaborales addJord(JornadasLaborales jord) {
		return jordrepo.save(jord);
	}

	@Override
	public JornadasLaborales getJord(long id) throws Exception {
		return jordrepo.findById(id).orElseThrow(() -> new Exception("La Jornada para editar no existe"));
	}

	@Override
	public void updateJord(JornadasLaborales jord) {
		jordrepo.save(jord);
	}

	@Override
	public void deleteJord(long id) {
		jordrepo.deleteById(id);
	}
	
	
}
