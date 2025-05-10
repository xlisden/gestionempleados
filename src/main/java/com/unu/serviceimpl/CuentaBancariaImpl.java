package com.unu.serviceimpl;

import com.unu.entity.CuentaBancaria;
import com.unu.repository.CuentaBancariaRepository;
import com.unu.service.CuentaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("datosservice")
public class CuentaBancariaImpl implements CuentaBancariaService {

    @Autowired
    @Qualifier("cuentabancariarepository")
    private CuentaBancariaRepository datosrepo;
    @Autowired
    private CuentaBancariaRepository cuentabancariarepository;


    @Override
    public List<CuentaBancaria> listAllCuentas() {
        return datosrepo.findAll();
    }

    @Override
    public CuentaBancaria addDatos(CuentaBancaria cuenta) {
        return datosrepo.save(cuenta);
    }

    @Override
    public CuentaBancaria getDatos(long id) throws Exception {
        return datosrepo.findById(id).orElseThrow(() -> new Exception("La Cuenta no existe."));
    }

    @Override
    public void updateDatos(CuentaBancaria cuenta) {
        datosrepo.save(cuenta);
    }

    @Override
    public void deleteDatos(long id) {
        datosrepo.deleteById(id);
    }

    @Override
    public CuentaBancaria getByEmpleado(int id) throws Exception {
        return datosrepo.findByEmpleado(id);
    }

    @Override
    public boolean cciExists(String cci) {
        return cuentabancariarepository.cciExists(cci);
    }


}
