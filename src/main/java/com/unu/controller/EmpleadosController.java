package com.unu.controller;

import com.unu.controller.request.EditarEmpleadoRequest;
import com.unu.controller.request.InsertarEmpleadoRequest;
import com.unu.controller.request.PersonaRequest;
import com.unu.entity.CuentaBancaria;
import com.unu.entity.Empleado;
import com.unu.entity.dto.ContratoDto;
import com.unu.entity.dto.CuentaBancariaDto;
import com.unu.entity.dto.EmpleadoDetalleDto;
import com.unu.entity.dto.EmpleadoDto;
import com.unu.service.*;
import com.unu.serviceimpl.CuentaBancariaImpl;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
    
    
    @Autowired
    @Qualifier("contratoservice")
    private ContratoService controtoService;
    
    @Autowired
    @Qualifier("datosservice")
    private CuentaBancariaImpl cuentaService;
    
    
    
    
    @GetMapping({"/", ""})
    public ModelAndView empleados(@RequestParam(required = false) String nombre,
    							  @RequestParam(required = false) String jornad,
    							  @RequestParam(required = false) String areaa){
    	//System.out.println("nombre:  "+nombre);
    	//System.out.println("jornada: "+jornad);
    	//System.out.println("area:    "+areaa);
		if(logiservice.tiempoSesion()){
        ModelAndView mav = new ModelAndView("empleados/EmpleadosList");

        List<EmpleadoDto> empleados = new ArrayList<>();
        try {
            empleados = empleadoService.listAllEmpleados(nombre,areaa,jornad); //listAllEmpleadosOrdenActivo
        } catch (Exception e) {
            System.out.println("listEmpleados() -> " + e.getMessage());
        }

        mav.addObject("empleados", empleados);
        mav.addObject("areas", areaService.listAllAreas());
        mav.addObject("jornadas", jornadaService.listAllJornadas());

        return mav;
		}
		return new LoginController().login();
    }

    @GetMapping("/{id}")
    public ModelAndView detalle(@PathVariable int id) { 
		if(logiservice.tiempoSesion()){
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
		}
		return new LoginController().login();
    }

    /* Insertar */

    @GetMapping("/agregar")
    public ModelAndView insertarGetDatos(Model model){
        ModelAndView mav = new ModelAndView("empleados/AgregarEmpleado");
        if(logiservice.tiempoSesion()){
        mav.addObject("estadosciviles", empleadoService.getEstadosCiviles());
        mav.addObject("areas", areaService.listAllAreas());
        mav.addObject("jornadas", jornadaService.listAllJornadas());
        mav.addObject("modalidades", empleadoService.getModalidadesContrato());
        mav.addObject("bancos", empleadoService.getBancos());
        mav.addObject("empleado", new InsertarEmpleadoRequest());
        return mav;
		}
		return new LoginController().login();
    }
    
    @PostMapping("/agregar")
    public String insertarPostDatos(@ModelAttribute InsertarEmpleadoRequest empleado,
    								@RequestParam(name="file",required = false)MultipartFile foto){

    	try {
			Empleado nuevoEmpleado=empleadoService.empleadoBruto(empleado, foto);
	    		    	
	    	controtoService.addTipoM(controtoService.contratoEnBruto(empleado, nuevoEmpleado));
	    	cuentaService.addDatos(new CuentaBancaria(0,empleado.getBanco(),empleado.getCci(),nuevoEmpleado));
	    	System.out.println("funciono el insertar");
	    	return "redirect:/empleados";
		} catch (Exception e) {
			System.out.println(" nada master: "+e.getMessage());
			return "redirect:/empleados/agregar";
		}
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
    
    /*
    	
    	if(!foto.isEmpty()) {
    		String ruta="static/img";
    		
    		try {
				byte[] bytes = foto.getBytes();
				Path rutaAbsoluta = Paths.get(ruta+"//"+foto.getOriginalFilename());
				Files.write(rutaAbsoluta, bytes);
				
			} catch (Exception e) {
				System.out.println("foto no subida: "+e.getMessage());
			}
    	}else {
    		System.out.println("foto vacia 2");
		}*/


}
