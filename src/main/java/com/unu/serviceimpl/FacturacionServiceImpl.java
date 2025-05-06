package com.unu.serviceimpl;

import com.unu.entity.Facturacion;
import com.unu.entity.dto.FacturacionDto;
import com.unu.entity.enums.Bonificacion;
import com.unu.repository.EmpleadoRepository;
import com.unu.repository.FacturacionRepository;
import com.unu.service.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service("facturacionservice")
public class FacturacionServiceImpl implements FacturacionService {

    @Autowired
    @Qualifier("facturacionrepository")
    private FacturacionRepository factrepo;

    @Autowired
    @Qualifier("empleadorepository")
    private EmpleadoRepository empleadoRepository;

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

    @Override
    public List<FacturacionDto> listByEmpleado(int idEmpleado) {
        List<Facturacion> lista = factrepo.findByEmpleado(idEmpleado);
        List<FacturacionDto> facturas = new ArrayList<FacturacionDto>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        for(Facturacion f: lista) {
            FacturacionDto dto = new FacturacionDto();

            boolean bonificacion = Bonificacion.isBonificacion(f.getFechaPago());
            double montoBonificacion = (bonificacion) ? Bonificacion.bonitificacion : 0.0;
            double sueldoBruto = (bonificacion) ? f.getSueldoNeto() - Bonificacion.bonitificacion : f.getSueldoNeto();

            dto.setId(f.getId());
            dto.setFechaPago(format.format(Date.valueOf(f.getFechaPago())));
            dto.setSueldoBruto(sueldoBruto);
            dto.setBonificacion(montoBonificacion);
            dto.setSueldoNeto(f.getSueldoNeto());

            facturas.add(dto);
        }
        return facturas;
    }

}
