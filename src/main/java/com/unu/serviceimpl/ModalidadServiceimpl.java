package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.ModalidadContrato;
import com.unu.repository.ModalidadeContratoRepository;
import com.unu.service.ModalidadService;

@Service("modalidadservice")
public class ModalidadServiceimpl implements ModalidadService {

	@Autowired
	@Qualifier("modalidadrepository")
	private ModalidadeContratoRepository modarepo;

	@Override
	public List<ModalidadContrato> listAllModali(String moda) {
		// TODO Auto-generated method stub
		return modarepo.findAll();
	}

	@Override
	public ModalidadContrato addModali(ModalidadContrato moda) {
		return modarepo.save(moda);
	}

	@Override
	public ModalidadContrato getModali(long id) throws Exception {
		return modarepo.findById(id).orElseThrow(() -> new Exception("La Moda para editar no existe"));
	}

	@Override
	public void updateModali(ModalidadContrato moda) {
		modarepo.save(moda);
	}

	@Override
	public void deleteModali(long id) {
		modarepo.deleteById(id);
	}
}
