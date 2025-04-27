package com.unu.controller;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unu.entity.Login;
import com.unu.service.LoginService;

@Controller
@RequestMapping("/temp")
public class Controlador {
	
	@Autowired
	@Qualifier("loginservice")
	private LoginService logiservice;
	
	@GetMapping("/list")
	public ModelAndView inicial() {
		if(tiempoSesion()){
			ModelAndView mav = new ModelAndView("borrar");
			mav.addObject("login", logiservice.listAllLogin("sd"));
			return mav;
		}
		return new LoginController().login();
	}
	
	
	public boolean tiempoSesion() {
		try {
			LocalTime sesion=logiservice.getLogin(1).getHoras();
			LocalTime ahora = LocalTime.now();
			
			int diferencia=(sesion.getHour()-ahora.getHour())*60 - (sesion.getMinute()-ahora.getMinute());
			System.out.println("minutos en sesion: "+diferencia);
			if(diferencia<5 && logiservice.getLogin(1).isEstado()) {
				Login log=logiservice.getLogin(1);
				logiservice.updatelogin(new Login(1,log.getUsurio(),log.getContraseña(),log.getEmpleado(), true,log.getHoras()));
				return true;
			}
		} catch (Exception e) {
			System.out.println("---- CERRAR SESION| HAY ERROR  ---- : "+e.getMessage());
			return false;
		}
		System.out.println("---- CERRAR SESION  ----");
		return false;
	}
	
}
