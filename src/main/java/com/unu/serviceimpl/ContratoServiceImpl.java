package com.unu.serviceimpl;

import com.unu.controller.request.ContratoRequest;
import com.unu.entity.*;
import com.unu.repository.ContratoRepository;
import com.unu.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    public Contrato addContrato(ContratoRequest request) {
        Contrato contrato = new Contrato();

        contrato.setEmpleado(request.getEmpleado());
        contrato.setArea(request.getArea());
        contrato.setFechaEmision(request.getFechaEmision());
        contrato.setModalidadCont(request.getModalidad());
        contrato.setFechaInicio(request.getFechaInicio());
        contrato.setJornadaLaboral(request.getJornada());

        return contratoRepository.save(contrato);
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
    public void updateContrato(Contrato contrato) {
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

    @Override
    public boolean contratoIsActivo(int idEmpleado) {
        return contratoRepository.contratoIsActivo(idEmpleado);
    }

//    @Override
//    public ContratoRequest findByEmpleadoRequest(int idEmpleado)  throws Exception{
//        Contrato contrato = contratoRepository.findByEmpleado(idEmpleado);
//        ContratoRequest request = new ContratoRequest();
//        LocalDate hoy = LocalDate.now();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
//        if (contrato == null) {
//            throw new Exception("El Contrato no existe.");
//        }
//
//        request.setEmpleado(contrato.getEmpleado());
//        request.setArea(new Area());
//        request.setModalidad(new ModalidadContrato());
//        request.setJornada(new JornadaLaboral());
//        request.setFechaEmision(hoy);
//        request.setFechaInicio(hoy);
//        request.setFechaEmisionValue(format.format(Date.valueOf(LocalDate.now())));
//        request.setFechaInicioValue(format.format(Date.valueOf(LocalDate.now())));
//
//        return request;
//    }


}
