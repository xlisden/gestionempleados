package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.Banco;
import com.unu.repository.BancoRepository;
import com.unu.service.BancoService;

@Service("entidadservice")
public class BancoServiceImpl implements BancoService {
	
	@Autowired
	@Qualifier("entidadrepository")
	private BancoRepository entirepo;

	@Override
	public List<Banco> findAllEntidades() {
		return entirepo.findAll();
	}
}
