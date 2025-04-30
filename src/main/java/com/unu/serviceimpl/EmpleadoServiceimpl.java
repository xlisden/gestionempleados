package com.unu.serviceimpl;

import com.unu.entity.Contrato;
import com.unu.entity.CuentaBancaria;
import com.unu.entity.Empleado;
import com.unu.entity.dto.ContratoDto;
import com.unu.entity.dto.CuentaBancariaDto;
import com.unu.entity.dto.EmpleadoDto;
import com.unu.repository.ContratoRepository;
import com.unu.repository.CuentaBancariaRepository;
import com.unu.repository.EmpleadoRepository;
import com.unu.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service("empleadosservice")
public class EmpleadoServiceimpl implements EmpleadoService {

    @Autowired
    @Qualifier("empleadorepository")
    private EmpleadoRepository empleadoRepository;

    @Autowired
    @Qualifier("contratorepository")
    private ContratoRepository contratoRepository;
    
    @Autowired
    @Qualifier("cuentabancariarepository")
    private CuentaBancariaRepository cuentabancariarepository;

    @Override
    public List<EmpleadoDto> listAllEmpleados() {
        List<Empleado> lista = empleadoRepository.findAll();
        List<EmpleadoDto> empleados = new ArrayList<EmpleadoDto>();
        for (Empleado e : lista) {
            Contrato contrato = contratoRepository.findByEmpleado(e.getId());
            EmpleadoDto dto = new EmpleadoDto();

            dto.setId(e.getId());
            dto.setCod(e.getCod());
            dto.setDni(e.getDni());
            dto.setNombreCompleto(e.getNombre() + " " + e.getApPaterno().toUpperCase() + " " + e.getApMaterno().toUpperCase());
            dto.setGenero((e.isGenero()) ? "Femenino" : "Masculino");
            dto.setArea((contrato.getArea() == null) ? "" : contrato.getArea().getNombre());
            dto.setModalidadContrato((contrato.getModalidadCont() == null) ? "" : contrato.getModalidadCont().getNombre());
            dto.setJornadaLaboral((contrato.getJornadaLaboral() == null) ? "" : contrato.getJornadaLaboral().getNombre());
            dto.setEstadoCivil((e.getEstadoCivil() == null) ? "" : e.getEstadoCivil().getNombre());
            dto.setEdad(calcularEdad(e.getFechaNac()));
            dto.setEstado(e.isActivo() ? "Activo" : "Inactivo");
            dto.setAntiguedad(calcularAnitguedad(contrato.getFechaInicio()));

            empleados.add(dto);
        }
        return empleados;
    }

    @Override
    public Empleado addEmple(Empleado emple) {
        return empleadoRepository.save(emple);
    }

    @Override
    public EmpleadoDto getEmpleado(int id) throws Exception {
        Empleado e = empleadoRepository.findById(id).orElseThrow(() -> new Exception("El Empleado no existe."));
        Contrato contrato = contratoRepository.findByEmpleado(e.getId());
        EmpleadoDto dto = new EmpleadoDto();

        dto.setId(e.getId());
        dto.setCod(e.getCod());
        dto.setDni(e.getDni());
        dto.setNombre(e.getNombre());
        dto.setApPaterno(e.getApPaterno());
        dto.setApMaterno(e.getApMaterno());
        dto.setNombreCompleto(e.getNombre() + " " + e.getApPaterno().toUpperCase() + " " + e.getApMaterno().toUpperCase());
        dto.setGenero((e.isGenero()) ? "Femenino" : "Masculino");
        dto.setArea((contrato.getArea() == null) ? "" : contrato.getArea().getNombre());
        dto.setModalidadContrato((contrato.getModalidadCont() == null) ? "" : contrato.getModalidadCont().getNombre());
        dto.setJornadaLaboral((contrato.getJornadaLaboral() == null) ? "" : contrato.getJornadaLaboral().getNombre());
        dto.setEstadoCivil((e.getEstadoCivil() == null) ? "" : e.getEstadoCivil().getNombre());
        dto.setEdad(calcularEdad(e.getFechaNac()));
        dto.setEstado(e.isActivo() ? "Activo" : "Inactivo");
        dto.setAntiguedad(calcularAnitguedad(contrato.getFechaInicio()));

        return dto;
    }

    @Override
    public void updateEmple(Empleado emple) {
        empleadoRepository.save(emple);
    }

    @Override
    public void deleteEmple(long id) {
        // TODO Auto-generated method stub
        empleadoRepository.deleteById(id);
    }

    @Override
    public CuentaBancariaDto getCuentaBancaria(int id) throws Exception {
        CuentaBancaria cuenta = cuentabancariarepository.findByEmpleado(id);
        CuentaBancariaDto dto = new CuentaBancariaDto();

        dto.setId(cuenta.getId());
        dto.setBanco(cuenta.getBanco().getNombre());
        dto.setCci(cuenta.getCci());

        return dto;
    }

    @Override
    public ContratoDto getContrato(int id) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Contrato contrato = contratoRepository.findByEmpleado(id);
        ContratoDto dto = new ContratoDto();

        dto.setId(contrato.getId());
        dto.setAntiguedad(calcularAnitguedad(contrato.getFechaEmision()));
        dto.setModalidadContrato(contrato.getModalidadCont().getNombre());
        dto.setFechaInicio(format.format(Date.valueOf(contrato.getFechaInicio())));
        dto.setFechaFin(format.format(Date.valueOf(contrato.getFechaFin())));
        dto.setArea(contrato.getArea().getNombre());
        dto.setSueldoBasico(contrato.getArea().getSueldoBasico());
        dto.setJornadaLaboral(contrato.getJornadaLaboral().getNombre());

        return dto;
    }

    public String calcularAnitguedad(LocalDate inicio) {
        Period periodo = Period.between(inicio, LocalDate.now());
        int anios = periodo.getYears();
        int meses = periodo.getMonths();

        return anios + " años, " + meses + " meses";
    }

    public int calcularEdad(LocalDate fechaNac) {
        Period periodo = Period.between(fechaNac, LocalDate.now());

        return periodo.getYears();
    }
}	
