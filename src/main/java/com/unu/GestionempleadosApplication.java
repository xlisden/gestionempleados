package com.unu;

import com.unu.entity.Area;
import com.unu.entity.EstadoCivil;
import com.unu.entity.JornadaLaboral;
import com.unu.entity.ModalidadContrato;
import com.unu.service.AreaService;
import com.unu.service.EstadoCivilService;
import com.unu.service.JornadaLaboralService;
import com.unu.service.ModalidadContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionempleadosApplication  implements CommandLineRunner {

	@Autowired
	@Qualifier("estadosservice")
	private EstadoCivilService estadoCivilService;

    @Autowired
    @Qualifier("modalidadcontratoservice")
    private ModalidadContratoService modContratoService;

	@Autowired
	@Qualifier("areaservice")
	private AreaService areaService;

	@Autowired
	@Qualifier("jornadaservice")
	private JornadaLaboralService jornadaService;

	public static void main(String[] args) {
		SpringApplication.run(GestionempleadosApplication.class, args);
		System.out.println("READY!");
	}

	public void run(String... args) throws Exception {
		if(estadoCivilService.listAllEstados().isEmpty()) {
			estadoCivilService.addEstados(new EstadoCivil("Soltero"));
			estadoCivilService.addEstados(new EstadoCivil("Casado"));
			estadoCivilService.addEstados(new EstadoCivil("Divorciado"));
			estadoCivilService.addEstados(new EstadoCivil("Viudo"));
		}

        if(modContratoService.listAllModalidades().isEmpty()){
			modContratoService.addModalidad(new ModalidadContrato("Plazo Indeterminado"));
			modContratoService.addModalidad(new ModalidadContrato("Plazo Determinado"));
        }

		if(areaService.listAllAreas().isEmpty()) {
			areaService.addArea(new Area("Finanzas", 1200.0));
			areaService.addArea(new Area("Servicio Al Cliente", 1400.0));
			areaService.addArea(new Area("Marketing", 1600.0));
			areaService.addArea(new Area("Administración", 1800.0));
		}

		if(jornadaService.listAllJornadas().isEmpty()) {
			jornadaService.addJord(new JornadaLaboral("Tiempo Completo"));
			jornadaService.addJord(new JornadaLaboral("Tiempo Parcial"));
		}
	}

}
