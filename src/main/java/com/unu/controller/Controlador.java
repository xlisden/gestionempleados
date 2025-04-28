package com.unu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unu.service.LoginService;

@Controller
@RequestMapping("/temp")
public class Controlador {
	
	@Autowired
	@Qualifier("loginservice")
	private LoginService logiservice;
	
	@GetMapping("/list")
	public ModelAndView inicial() {
		ModelAndView mav = new ModelAndView("borrar");
		System.out.println("--------pip-------");
		mav.addObject("login", logiservice.listAllLogin("sd"));
		return mav;
	}
	
}
