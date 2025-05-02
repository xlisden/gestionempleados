package com.unu.serviceimpl;

import com.unu.entity.Contrato;
import com.unu.repository.ContratoRepository;
import com.unu.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contratoservice")
public class ContratoServiceImpl implements ContratoService {
    @Autowired
    @Qualifier("contratorepository")
    private ContratoRepository contratoRepository;

    @Override
    public List<Contrato> listAllContratos() {
        return contratoRepository.findAll();
    }

    @Override
    public Contrato addTipoM(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    @Override
    public Contrato getTipoM(long id) throws Exception {
        return contratoRepository.findById(id).orElseThrow(() -> new Exception("El Contrato no existe."));
    }

    @Override
    public void updateTipoM(Contrato contrato) {
        contratoRepository.save(contrato);
    }

    @Override
    public void deleteTipoM(long id) {
        contratoRepository.deleteById(id);
    }

    @Override
    public Contrato findByEmpleado(int idEmpleado) {
        return contratoRepository.findByEmpleado(idEmpleado);
    }


}
