package com.unu.controller;

import com.unu.controller.request.EditarEmpleadoRequest;
import com.unu.controller.request.InsertarEmpleadoRequest;
import com.unu.controller.request.PersonaRequest;
import com.unu.entity.dto.ContratoDto;
import com.unu.entity.dto.CuentaBancariaDto;
import com.unu.entity.dto.EmpleadoDetalleDto;
import com.unu.entity.dto.EmpleadoDto;
import com.unu.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    private AreaService areaService;

    @Autowired
    @Qualifier("jornadaservice")
    private JornadaLaboralService jornadaService;

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
    public ModelAndView listEmpleados() {
//		if(logiservice.tiempoSesion()){
        ModelAndView mav = new ModelAndView("empleados/EmpleadosList");

        List<EmpleadoDto> empleados = new ArrayList<>();
        try {
            empleados = empleadoService.listAllEmpleados();
        } catch (Exception e) {
            System.out.println("listEmpleados() -> " + e.getMessage());
        }

        mav.addObject("empleados", empleados);
        mav.addObject("areas", areaService.listAllAreas());
        mav.addObject("jornadas", jornadaService.listAllJornadas());

        return mav;
//		}
//		return new LoginController().login();
    }

    @GetMapping("/{id}")
    public ModelAndView detalle(@PathVariable int id) { // falta mandarle argumento ID
//		if(logiservice.tiempoSesion()){
        ModelAndView mav = new ModelAndView("empleados/EmpleadoDetalle");
        EmpleadoDetalleDto empleado = new EmpleadoDetalleDto();
        CuentaBancariaDto cuenta = new CuentaBancariaDto();
        ContratoDto contrato = new ContratoDto();

        try {
            empleado = empleadoService.getEmpleado(id);
            cuenta = empleadoService.getCuentaBancaria(id);
            contrato = empleadoService.getContrato(id);
        } catch (Exception e) {
            System.out.println("fallo en la captura de datos: " + e.getMessage());
        }

        mav.addObject("empleado", empleado);
        mav.addObject("cuentaBancaria", cuenta);
        mav.addObject("contrato", contrato);

        return mav;
//		}
//		return new LoginController().login();
    }

    /* Insertar */

    @GetMapping("/agregar")
    public ModelAndView insertarGetDatos(Model model){
        ModelAndView mav = new ModelAndView("empleados/AgregarEmpleado");

        mav.addObject("estadosciviles", empleadoService.getEstadosCiviles());
        mav.addObject("areas", areaService.listAllAreas());
        mav.addObject("jornadas", jornadaService.listAllJornadas());
        mav.addObject("modalidades", empleadoService.getModalidadesContrato());
        mav.addObject("bancos", empleadoService.getBancos());
        return mav;
    }

    @GetMapping("/personas")
    public ModelAndView getPersona(){
        ModelAndView mav = new ModelAndView("personas");

        mav.addObject("persona", new PersonaRequest());
        mav.addObject("hayErrorInsertar", false);
        mav.addObject("estadosciviles", empleadoService.getEstadosCiviles());
        return mav;
    }

    // si sabes hacer el postmapping con model and view le haces pue (io no se)
    @PostMapping("/personas")
    public String addPersona(@Valid @ModelAttribute("persona") PersonaRequest personaRequest, BindingResult result, Model model){
        try {
            // || personaRequest.getEstadoCivil() == null
            if (result.hasErrors()) {
                if (personaRequest.getEstadoCivil() == null){
                    result.rejectValue("estadoCivil", "error.estadoCivil.notnull", "El Estado Civil es requerido.");
                }
                if (personaRequest.getFechaNacimiento() == null){
                    result.rejectValue("fechaNacimiento", "error.fechaNacimiento.notnull", "La fecha de nacimiento es requerida.");
                }
                model.addAttribute("hayErrorInsertar", true);
                model.addAttribute("estadosciviles", empleadoService.getEstadosCiviles());
                return "personas";
            }
            System.out.println("nombre = " + personaRequest.getNombre());
            System.out.println("estado civil = " + personaRequest.getEstadoCivil().getNombre());
            System.out.println("fecha nac = " + personaRequest.getFechaNacimiento());
            model.addAttribute("hayErrorInsertar", false);
        } catch (Exception e) {
            System.out.println("addPersona() -> " + e.getMessage());
        }
        return "redirect:/empleados/personas";
    }


    /* Editar */

    @GetMapping("/editar/{id}")
    public ModelAndView editarGetDatos(@PathVariable int id) {
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

    @PutMapping("/editar/{id}")
    private String editar(@PathVariable int id, @Valid @ModelAttribute EditarEmpleadoRequest empleadoRequest, BindingResult bindingResult, Model model) {
        return "";
    }

    @PatchMapping("/desactivar/{id}")
    public String deasctivar(@PathVariable int id) {
        empleadoService.desactivar(id);

        return "redirect:/empleados";
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

    private void borrar() {
        InsertarEmpleadoRequest request = new InsertarEmpleadoRequest();
        request.getApMaterno();
    }

}
