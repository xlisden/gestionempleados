package com.unu;

import com.unu.entity.EstadoCivil;
import com.unu.service.EstadoCivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionempleadosApplication {

	@Autowired
	@Qualifier("estadosservice")
	private EstadoCivilService estadoCivilService;

	public static void main(String[] args) {
		SpringApplication.run(GestionempleadosApplication.class, args);
	}

	public void run(String... args) throws Exception {
		if(estadoCivilService.listAllEstados().isEmpty()) {
			estadoCivilService.addEstados(new EstadoCivil("Soltero"));
			estadoCivilService.addEstados(new EstadoCivil("Casado"));
			estadoCivilService.addEstados(new EstadoCivil("Divorciado"));
			estadoCivilService.addEstados(new EstadoCivil("Viudo"));
		}
	}


}
