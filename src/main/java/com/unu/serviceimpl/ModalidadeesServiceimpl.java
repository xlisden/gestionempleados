package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.Modalidades_contrato;
import com.unu.repository.Modalidades_contratoRepository;
import com.unu.service.ModalidadesService;

@Service("modalidadservice")
public class ModalidadeesServiceimpl implements ModalidadesService {

	@Autowired
	@Qualifier("modalidadrepository")
	private Modalidades_contratoRepository modarepo;

	@Override
	public List<Modalidades_contrato> listAllModali(String moda) {
		// TODO Auto-generated method stub
		return modarepo.findAll();
	}

	@Override
	public Modalidades_contrato addmoda(Modalidades_contrato moda) {
		return modarepo.save(moda);
	}

	@Override
	public Modalidades_contrato getmoda(long id) throws Exception {
		return modarepo.findById(id).orElseThrow(() -> new Exception("La Moda para editar no existe"));
	}

	@Override
	public void updatemoda(Modalidades_contrato moda) {
		modarepo.save(moda);
	}

	@Override
	public void deletemoda(long id) {
		modarepo.deleteById(id);
	}
}
