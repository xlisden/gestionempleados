package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.Facturaciones;
import com.unu.repository.FacturacionesRepository;
import com.unu.service.FacturacionesService;

@Service("facturasservice")
public class FacturacionServiceimpl implements FacturacionesService{
	@Autowired
	@Qualifier("facturasrepository")
	private FacturacionesRepository factrepo;

	@Override
	public List<Facturaciones> listAllFact(String fact) {
		// TODO Auto-generated method stub
		return factrepo.findAll();
	}

	@Override
	public Facturaciones addFact(Facturaciones fact) {
		return factrepo.save(fact);
	}

	@Override
	public Facturaciones getFact(long id) throws Exception {
		return factrepo.findById(id).orElseThrow(() -> new Exception("La Factura para editar no existe"));
	}

	@Override
	public void updateFact(Facturaciones fact) {
		factrepo.save(fact);
	}

	@Override
	public void deleteFact(long id) {
		factrepo.deleteById(id);
	}
	
}
