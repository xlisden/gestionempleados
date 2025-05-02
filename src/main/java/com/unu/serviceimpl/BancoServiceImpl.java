package com.unu.serviceimpl;

import com.unu.entity.Banco;
import com.unu.repository.BancoRepository;
import com.unu.service.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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
