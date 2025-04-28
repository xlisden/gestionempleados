package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.Jornadas_laborales;
import com.unu.repository.Jornadas_laboralesRepository;
import com.unu.service.JornadasService;

@Service
public class JornadasServiceimpl implements JornadasService {
	@Autowired
	@Qualifier("jornadasrepository")
	private Jornadas_laboralesRepository jordrepo;

	@Override
	public List<Jornadas_laborales> listAllJornada(String jord) {
		// TODO Auto-generated method stub
		return jordrepo.findAll();
	}

	@Override
	public Jornadas_laborales addJord(Jornadas_laborales jord) {
		return jordrepo.save(jord);
	}

	@Override
	public Jornadas_laborales getJord(long id) throws Exception {
		return jordrepo.findById(id).orElseThrow(() -> new Exception("La Jornada para editar no existe"));
	}

	@Override
	public void updatejord(Jornadas_laborales jord) {
		jordrepo.save(jord);
	}

	@Override
	public void deletejord(long id) {
		jordrepo.deleteById(id);
	}
	
	
}
