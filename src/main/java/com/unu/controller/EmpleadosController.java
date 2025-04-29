package com.unu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unu.entity.Empleados;
import com.unu.service.AreasService;
import com.unu.service.EmpleadosService;
import com.unu.service.EstadosCivilesService;
import com.unu.service.JornadasService;
import com.unu.service.LoginService;

@Controller
@RequestMapping("/empleados")
public class EmpleadosController {
	
	@Autowired
	@Qualifier("loginservice")
	private LoginService logiservice;
	
	@Autowired
	@Qualifier("areaservice")
	private AreasService areaservice;
	
	@Autowired
	@Qualifier("jornadaservice")
	private JornadasService jorservice;
	
	@Autowired
	@Qualifier("estadosservice")
	private EstadosCivilesService estaservice;
	
	@Autowired
	@Qualifier("empleadosservice")
	private EmpleadosService empleservice;
	
	@GetMapping({"/", ""})
	public ModelAndView empleados() {
		if(logiservice.tiempoSesion()){
			ModelAndView mav = new ModelAndView("empleados/EmpleadosList");
			
			List<Empleados> empleados = empleservice.listAllEmpleados("");
			List<String[]> listaEmple = new ArrayList<String[]>();
			
			for (Empleados e : empleados) {
				String datos[]= new String[7];
				
				datos[0]=e.getEmpleadoCod();
				datos[1]=e.getNombres()+" "+e.getApPaterno()+" "+e.getApMaterno();
				datos[2]="tiempoEstubo";
				datos[3]=e.getArea().getNombre();
				datos[4]="contratado ?";
				datos[5]=e.getJornada().getNombre();
				datos[6]=e.getIdEmpleado()+"";  // por siaca
				
				listaEmple.add(datos);
			}
			mav.addObject("empleados",listaEmple);
			return mav;
		}
		return new LoginController().login();
	}
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/detalleemple")
	public ModelAndView detalle() {
		if(logiservice.tiempoSesion()){
			ModelAndView mav = new ModelAndView("detalle");
			mav.addObject("empleados",empleservice.listAllEmpleados(""));
			return mav;
		}
		return new LoginController().login();
	}
	
	@GetMapping("/editaremple")
	public ModelAndView editar() {
		if(logiservice.tiempoSesion()){
			ModelAndView mav = new ModelAndView("editar");
			mav.addObject("areas", areaservice.listAllAreas(""));
			mav.addObject("jornadas", jorservice.listAllJornada(""));
			mav.addObject("estados", estaservice.listAllEstados(""));
			mav.addObject("empleado",new Empleados());
			return mav;
		}
		return new LoginController().login();
	}
	
}
