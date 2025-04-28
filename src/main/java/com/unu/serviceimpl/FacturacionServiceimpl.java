package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.Facturacion;
import com.unu.repository.FacturacionRepository;
import com.unu.service.FacturacionService;

@Service("facturasservice")
public class FacturacionServiceimpl implements FacturacionService{
	@Autowired
	@Qualifier("facturasrepository")
	private FacturacionRepository factrepo;

	@Override
	public List<Facturacion> listAllFact(String fact) {
		// TODO Auto-generated method stub
		return factrepo.findAll();
	}

	@Override
	public Facturacion addFact(Facturacion fact) {
		return factrepo.save(fact);
	}

	@Override
	public Facturacion getFact(long id) throws Exception {
		return factrepo.findById(id).orElseThrow(() -> new Exception("La Factura para editar no existe"));
	}

	@Override
	public void updatefact(Facturacion fact) {
		factrepo.save(fact);
	}

	@Override
	public void deletefact(long id) {
		factrepo.deleteById(id);
	}
	
}
