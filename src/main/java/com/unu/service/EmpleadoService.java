package com.unu.service;

import com.unu.controller.request.InsertarEmpleadoRequest;
import com.unu.entity.*;
import com.unu.entity.dto.*;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface EmpleadoService {

	public abstract List<EmpleadoDto> listAllEmpleados(String texto , String idArea,String idJornada);

    public abstract Empleado addEmple(Empleado emple);

    public abstract EmpleadoDetalleDto getEmpleado(int id) throws Exception;

    public abstract void updateEmple(Empleado emple);

    public abstract void deleteEmple(long id);

    public abstract CuentaBancariaDto getCuentaBancaria(int id) throws Exception;

    public abstract ContratoDto getContratoDto(int id) throws Exception;

    public abstract FacturacionDto emitirRecibo(int id, boolean bonificacion) throws Exception;

    public abstract FacturacionDto getDatosEmitirRecibo(int id) throws Exception;

    public abstract boolean dniExists(String dni);

    public abstract void desactivar(int id);

    public abstract void activar(int id);

    public abstract List<EstadoCivil> getEstadosCiviles();

    public abstract List<ModalidadContrato> getModalidadesContrato();

    public abstract List<Banco> getBancos();
    
    public abstract Empleado empleadoBruto(InsertarEmpleadoRequest e, MultipartFile foto);

    public abstract List<EmpleadoDto> listAllEmpleadosOrdenActivo();

}
