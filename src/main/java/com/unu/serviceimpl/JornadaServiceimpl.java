package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.JornadasLaborale;
import com.unu.repository.JornadasLaboraleRepository;
import com.unu.service.JornadaService;

@Service("jornadaservice")
public class JornadaServiceimpl implements JornadaService {
	@Autowired
	@Qualifier("jornadasrepository")
	private JornadasLaboraleRepository jordrepo;

	@Override
	public List<JornadasLaborale> listAllJornada(String jord) {
		// TODO Auto-generated method stub
		return jordrepo.findAll();
	}

	@Override
	public JornadasLaborale addJord(JornadasLaborale jord) {
		return jordrepo.save(jord);
	}

	@Override
	public JornadasLaborale getJord(long id) throws Exception {
		return jordrepo.findById(id).orElseThrow(() -> new Exception("La Jornada para editar no existe"));
	}

	@Override
	public void updateJord(JornadasLaborale jord) {
		jordrepo.save(jord);
	}

	@Override
	public void deleteJord(long id) {
		jordrepo.deleteById(id);
	}
	
	
}
