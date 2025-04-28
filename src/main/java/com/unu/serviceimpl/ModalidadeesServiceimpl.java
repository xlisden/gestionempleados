package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.ModalidadesContrato;
import com.unu.repository.ModalidadesContratoRepository;
import com.unu.service.ModalidadesService;

@Service("modalidadservice")
public class ModalidadeesServiceimpl implements ModalidadesService {

	@Autowired
	@Qualifier("modalidadrepository")
	private ModalidadesContratoRepository modarepo;

	@Override
	public List<ModalidadesContrato> listAllModali(String moda) {
		// TODO Auto-generated method stub
		return modarepo.findAll();
	}

	@Override
	public ModalidadesContrato addModali(ModalidadesContrato moda) {
		return modarepo.save(moda);
	}

	@Override
	public ModalidadesContrato getModali(long id) throws Exception {
		return modarepo.findById(id).orElseThrow(() -> new Exception("La Moda para editar no existe"));
	}

	@Override
	public void updateModali(ModalidadesContrato moda) {
		modarepo.save(moda);
	}

	@Override
	public void deleteModali(long id) {
		modarepo.deleteById(id);
	}
}
