package com.unu.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unu.entity.Empleado;
import com.unu.service.AreaService;
import com.unu.service.DatosBancarioService;
import com.unu.service.EmpleadoService;
import com.unu.service.EstadosCivileService;
import com.unu.service.JornadaService;
import com.unu.service.LoginService;
import com.unu.service.ModalidadService;

@Controller
@RequestMapping("/temp")
public class EmpleadoControlador {
	
	@Autowired
	@Qualifier("loginservice")
	private LoginService logiservice;
	
	@Autowired
	@Qualifier("areaservice")
	private AreaService areaservice;
	
	@Autowired
	@Qualifier("jornadaservice")
	private JornadaService jorservice;
	
	@Autowired
	@Qualifier("estadosservice")
	private EstadosCivileService estaservice;
	
	@Autowired
	@Qualifier("modalidadservice")
	private ModalidadService modalidadservice;
	
	@Autowired
	@Qualifier("datosservice")
	private DatosBancarioService datosservice;
	
	@Autowired
	@Qualifier("empleadosservice")
	private EmpleadoService empleservice;
	
	@GetMapping("/listaemple")
	public ModelAndView empleados() {
		if(logiservice.tiempoSesion()){
			ModelAndView mav = new ModelAndView("empleados");
			
			List<Empleado> empleados = empleservice.listAllEmpleados("");
			List<String[]> listaEmple = new ArrayList<String[]>();
			
			for (Empleado e : empleados) {
				String datos[]= new String[7];
				
				datos[0]=e.getEmpleadoCod();
				datos[1]=e.getNombres()+" "+e.getApPaterno()+" "+e.getApMaterno();
				datos[2]=calcularTiempo(e.getFechaIngreso());
				datos[3]=e.getArea().getNombre();
				datos[4]=modalidad(e.getIdEmpleado());
				datos[5]=e.getJornada().getNombre();
				datos[6]=e.getIdEmpleado()+"";  // por siaca
				
				listaEmple.add(datos);
			}
			mav.addObject("empleados",listaEmple);
			mav.addObject("areas", areaservice.listAllAreas(""));
			mav.addObject("jornadas", jorservice.listAllJornada(""));
			return mav;
		}
		return new LoginController().login();
	}	
		
	@GetMapping("/detalleemple")
	public ModelAndView detalle() { // falta mandarle argumento ID
		if(logiservice.tiempoSesion()){
			ModelAndView mav = new ModelAndView("detalle");
			String datosPersonales[] = new String[10];
			String datosBanco[]      = new String[2];
			String datosContrato[]   = new String [7];
			
			try {
				Empleado e = empleservice.getEmple(1); // ID
				
				datosPersonales[0]="Nombres: "+e.getNombres();
				datosPersonales[1]="Apellido P: "+e.getApPaterno();
				datosPersonales[2]="Apellido M: "+e.getApMaterno();
				datosPersonales[3]="DNI: "+e.getDni();
				datosPersonales[4]="Estado C: "+e.getEstadoC().getNombre();
				datosPersonales[5]="Edad: "+ calcularAnio(e.getFechaNaci());
				datosPersonales[6]="Genero: "+ genero(e.isGenero());
				datosPersonales[7]=e.getFoto();
				datosPersonales[8]=e.isEstado()+"";
				datosPersonales[9]=e.getIdEmpleado()+""; // para los cambios ocupados Id 

				datosBanco[0]="Entidad: "+datosservice.getDatosByEmpleado(e.getIdEmpleado()).getEntidadBancaria().getNombre();
				datosBanco[1]="CCI: "+datosservice.getDatosByEmpleado(e.getIdEmpleado()).getCci();
				
				datosContrato[0]="Tiempo en la empresa: "+calcularTiempo(e.getFechaIngreso());
				datosContrato[1]="Modalidad: "+modalidadservice.getModali(e.getIdEmpleado()).getTipomodalidad().getNombre();
				datosContrato[2]="Inicio Contr: "+modalidadservice.getModali(e.getIdEmpleado()).getFechaInicio()+"";
				datosContrato[3]="Final Contra: "+modalidadservice.getModali(e.getIdEmpleado()).getFechaFin()+"";
				datosContrato[4]="Area: "+e.getArea().getNombre();
				datosContrato[5]="Salario :p "+e.getArea().getSalario()+"";
				datosContrato[6]="Jornada: "+jorservice.getJord(e.getIdEmpleado()).getNombre();
				
			} catch (Exception e) {
				System.out.println("fallo en la captura de datos: "+e.getMessage());
			}
			mav.addObject("datosPer",datosPersonales);
			mav.addObject("datosCon",datosContrato);
			mav.addObject("datosBan",datosBanco);
			return mav;
		}
		return new LoginController().login();
	}
	
	
	
	
	
	
	@GetMapping("/editaremple")
	public ModelAndView editar() {
		if(logiservice.tiempoSesion()){
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
		int anio=LocalDate.now().getYear()-ingreso.getYear();
		int mes=LocalDate.now().getMonthValue()-ingreso.getMonthValue();
		int dia=LocalDate.now().getDayOfMonth()-ingreso.getDayOfMonth();
		
		return anio+" años   "+mes+" meses   "+dia+" dias ";
	}
	
	public String modalidad(int idemple) {
		String modalidad ="no-se-encontro";
		try {
			modalidad=modalidadservice.getModali(idemple).getTipomodalidad().getNombre();
		} catch (Exception e) {
			System.out.println("Modalidad no encontrada: "+e.getMessage());
		}
		return modalidad;
	}
	
	public String calcularAnio(LocalDate antes) {
		LocalDate actual = LocalDate.now();
		if(antes.getMonthValue()<actual.getMonthValue() || (antes.getMonthValue()==actual.getMonthValue()) && antes.getDayOfMonth()<actual.getDayOfMonth()) {
			return actual.getYear()-(antes.getYear()+1)+" años ";
		}else {
			return actual.getYear()-antes.getYear()+" años ";
		}
	}
	public String genero(boolean genero) {
		if(genero) return "M";
		return "F";
	}
	
	
	
	
	
	
	
	
	
	
	// borrador prueba 1 , no lo borre me da pena xd
		@GetMapping("/list")
		public ModelAndView inicial() {
			if(logiservice.tiempoSesion()){
				ModelAndView mav = new ModelAndView("borrar");
				mav.addObject("login", logiservice.listAllLogin("sd"));
				return mav;
			}
			return new LoginController().login();
		}
}
