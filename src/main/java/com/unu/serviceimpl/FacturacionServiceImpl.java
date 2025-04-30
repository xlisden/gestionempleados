package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.Facturacion;
import com.unu.repository.FacturacionRepository;
import com.unu.service.FacturacionService;

@Service("facturacionservice")
public class FacturacionServiceImpl implements FacturacionService {
	@Autowired
	@Qualifier("facturacionrepository")
	private FacturacionRepository factrepo;

	@Override
	public List<Facturacion> listAllFact() {
		// TODO Auto-generated method stub
		return factrepo.findAll();
	}

	@Override
	public Facturacion addFact(Facturacion fact) {
		return factrepo.save(fact);
	}

	@Override
	public Facturacion getFact(long id) throws Exception {
		return factrepo.findById(id).orElseThrow(() -> new Exception("La Factura no existe."));
	}

	@Override
	public void updateFact(Facturacion fact) {
		factrepo.save(fact);
	}

	@Override
	public void deleteFact(long id) {
		factrepo.deleteById(id);
	}
	
}
