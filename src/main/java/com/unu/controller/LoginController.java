package com.unu.controller;

import com.unu.entity.Login;
import com.unu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/sis")
public class LoginController {

	@Autowired
	@Qualifier("loginservice")
	private LoginService logiservice;

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("Logeo");
		mav.addObject("login", new Login());
		//validar
		return new ModelAndView("empleados/EmpleadosList");
	}

	@PostMapping("/login")
	public String login(@ModelAttribute Login log) {
		// if(logiservice.validacion(log.getUsurio(),log.getContraseña()))
		return "redirect:/empleados";
		// else
		// 	return "redirect:/sis/login";
	}
}
