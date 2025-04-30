package com.unu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.EntidadBancaria;
import com.unu.repository.EntidadBancariaRepository;
import com.unu.service.EntidadBancariaService;

@Service("entidadservice")
public class EntidadBancariaServiceimpl implements EntidadBancariaService {
	
	@Autowired
	@Qualifier("entidadrepository")
	private EntidadBancariaRepository entirepo;

	@Override
	public List<EntidadBancaria> findAllEntidades() {
		return entirepo.findAll();
	}
}
