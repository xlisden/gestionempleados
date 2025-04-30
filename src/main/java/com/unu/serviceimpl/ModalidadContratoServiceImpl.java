package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.ModalidadContrato;
import com.unu.repository.ModalidadContratoRepository;
import com.unu.service.ModalidadContratoService;

@Service("modalidadcontratoservice")
public class ModalidadContratoServiceImpl implements ModalidadContratoService {

	@Autowired
	@Qualifier("modalidadcontratorepository")
	private ModalidadContratoRepository modContratoRepository;

	@Override
	public List<ModalidadContrato> listAllModalidades() {
		return modContratoRepository.findAll();
	}

	@Override
	public ModalidadContrato addModalidad(ModalidadContrato moda) {
		return modContratoRepository.save(moda);
	}

	@Override
	public ModalidadContrato getModalidad(long id) throws Exception {
		return modContratoRepository.findById(id).orElseThrow(() -> new Exception("La Modalidad de Contrato no existe."));
	}

	@Override
	public void updateModali(ModalidadContrato modContrato) {
		modContratoRepository.save(modContrato);
	}

	@Override
	public void deleteModali(long id) {
		modContratoRepository.deleteById(id);
	}
}
