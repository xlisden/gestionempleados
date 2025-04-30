package com.unu.controller;

import com.unu.entity.dto.ContratoDto;
import com.unu.entity.dto.CuentaBancariaDto;
import com.unu.entity.dto.EmpleadoDto;
import com.unu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/empleados")
public class EmpleadosController {

    @Autowired
    @Qualifier("loginservice")
    private LoginService logiservice;

    @Autowired
    @Qualifier("areaservice")
    private AreaService areaservice;

    @Autowired
    @Qualifier("jornadaservice")
    private JornadaLaboralService jorservice;

    @Autowired
    @Qualifier("estadosservice")
    private EstadoCivilService estaservice;

    @Autowired
    @Qualifier("modalidadcontratoservice")
    private ModalidadContratoService modalidadservice;

    @Autowired
    @Qualifier("datosservice")
    private CuentaBancariaService datosservice;

    @Autowired
    @Qualifier("empleadosservice")
    private EmpleadoService empleadoService;

    @GetMapping({"/", ""})
    public ModelAndView empleados() {
//		if(logiservice.tiempoSesion()){
        ModelAndView mav = new ModelAndView("empleados/EmpleadosList");

        List<EmpleadoDto> empleados = new ArrayList<>();
        try {
            empleados = empleadoService.listAllEmpleados();
        } catch (Exception e) {
            System.out.println("EmpleadosController - empleados() -> " + e.getMessage());
        }

        mav.addObject("empleados", empleados);
        mav.addObject("areas", areaservice.listAllAreas());
        mav.addObject("jornadas", jorservice.listAllJornadas());

        return mav;
//		}
//		return new LoginController().login();
    }

    @GetMapping("/{id}")
    public ModelAndView detalle(@PathVariable int id) { // falta mandarle argumento ID
//		if(logiservice.tiempoSesion()){
        ModelAndView mav = new ModelAndView("detalle");
        EmpleadoDto empleado = new EmpleadoDto();
        CuentaBancariaDto cuenta = new CuentaBancariaDto();
        ContratoDto contrato = new ContratoDto();

        try {
            empleado = empleadoService.getEmpleado(id);
            cuenta = empleadoService.getCuentaBancaria(id);
            contrato = empleadoService.getContrato(id);
        } catch (Exception e) {
            System.out.println("fallo en la captura de datos: " + e.getMessage());
        }
        System.out.println(empleado.toString());

        mav.addObject("empleado", empleado);
        mav.addObject("cuentaBancaria", cuenta);
        mav.addObject("contrato", contrato);

        return mav;
//		}
//		return new LoginController().login();
    }


    @GetMapping("/editaremple")
    public ModelAndView editar() {
        if (logiservice.tiempoSesion()) {
            ModelAndView mav = new ModelAndView("editar");
			/*
			mav.addObject("areas", areaservice.listAllAreas(""));
			mav.addObject("jornadas", jorservice.listAllJornada(""));
			mav.addObject("estados", estaservice.listAllEstados(""));
			mav.addObject("modalidad", modalidadservice.l);
			mav.addObject("empleado",new Empleado());
			*/
            return mav;
        }
        return new LoginController().login();
    }

    //seccion de funciones extras


    public String calcularTiempo(LocalDate ingreso) {
        int anio = LocalDate.now().getYear() - ingreso.getYear();
        int mes = LocalDate.now().getMonthValue() - ingreso.getMonthValue();
        int dia = LocalDate.now().getDayOfMonth() - ingreso.getDayOfMonth();

        return anio + " años   " + mes + " meses   " + dia + " dias ";
    }

    public String modalidad(int idemple) {
        String modalidad = "no-se-encontro";
        try {
//			modalidad=modalidadservice.getModalidad(idemple).getTipomodalidad().getNombre();
        } catch (Exception e) {
            System.out.println("Modalidad no encontrada: " + e.getMessage());
        }
        return modalidad;
    }

    public String calcularAnio(LocalDate antes) {
        LocalDate actual = LocalDate.now();
        if (antes.getMonthValue() < actual.getMonthValue() || (antes.getMonthValue() == actual.getMonthValue()) && antes.getDayOfMonth() < actual.getDayOfMonth()) {
            return actual.getYear() - (antes.getYear() + 1) + " años ";
        } else {
            return actual.getYear() - antes.getYear() + " años ";
        }
    }

    public String genero(boolean genero) {
        if (genero) return "M";
        return "F";
    }


    // borrador prueba 1 , no lo borre me da pena xd
    @GetMapping("/list")
    public ModelAndView inicial() {
        if (logiservice.tiempoSesion()) {
            ModelAndView mav = new ModelAndView("borrar");
            mav.addObject("login", logiservice.listAllLogin("sd"));
            return mav;
        }
        return new LoginController().login();
    }

}
