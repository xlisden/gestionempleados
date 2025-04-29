package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.Facturacione;
import com.unu.repository.FacturacioneRepository;
import com.unu.service.FacturacioneService;

@Service("facturasservice")
public class FacturacionServiceimpl implements FacturacioneService{
	@Autowired
	@Qualifier("facturasrepository")
	private FacturacioneRepository factrepo;

	@Override
	public List<Facturacione> listAllFact(String fact) {
		// TODO Auto-generated method stub
		return factrepo.findAll();
	}

	@Override
	public Facturacione addFact(Facturacione fact) {
		return factrepo.save(fact);
	}

	@Override
	public Facturacione getFact(long id) throws Exception {
		return factrepo.findById(id).orElseThrow(() -> new Exception("La Factura para editar no existe"));
	}

	@Override
	public void updateFact(Facturacione fact) {
		factrepo.save(fact);
	}

	@Override
	public void deleteFact(long id) {
		factrepo.deleteById(id);
	}
	
}
