package com.unu.controller;

import com.unu.controller.request.ContratoRequest;
import com.unu.entity.Contrato;
import com.unu.entity.Empleado;
import com.unu.service.AreaService;
import com.unu.service.ContratoService;
import com.unu.service.EmpleadoService;
import com.unu.service.JornadaLaboralService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/areas")
public class AreasController {

    @Autowired
    @Qualifier("contratoservice")
    private ContratoService contratoService;

    @Autowired
    @Qualifier("empleadosservice")
    private EmpleadoService empleadoService;

    @Autowired
    @Qualifier("areaservice")
    private AreaService areaService;

    @Autowired
    @Qualifier("jornadaservice")
    private JornadaLaboralService jornadaService;

    @GetMapping("/agregar-contrato")
    public ModelAndView agregarContratoGet() {
        ModelAndView mav = new ModelAndView("contratos/AgregarContrato");
        try {
            mav.addObject("hayErrores", false);
            mav.addObject("contrato", new ContratoRequest());
            mav.addObject("empleados", empleadoService.getAll());
            mav.addObject("areas", areaService.listAllAreas());
            mav.addObject("jornadas", jornadaService.listAllJornadas());
            mav.addObject("modalidades", empleadoService.getModalidadesContrato());
        } catch (Exception e) {
            System.out.println("agregarContratoGet() => " + e.getMessage());
        }
        return mav;
    }

    @GetMapping("/agregar-contrato/{id}")
    public ModelAndView agregarContratoGetEmp(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("contratos/AgregarContrato");
        try {
            Empleado empleado = empleadoService.getEmpleadoNormal(id);
            ContratoRequest contrato = new ContratoRequest();

            contrato.setEmpleado(empleado);
            mav.addObject("hayErrores", false);
            mav.addObject("contrato", contrato);
            mav.addObject("empleados", empleadoService.getAll());
            mav.addObject("areas", areaService.listAllAreas());
            mav.addObject("jornadas", jornadaService.listAllJornadas());
            mav.addObject("modalidades", empleadoService.getModalidadesContrato());
        } catch (Exception e) {
            System.out.println("agregarContratoGetEmp() => " + e.getMessage());
        }
        return mav;
    }

    @PostMapping("/agregar-contrato")
    public String agregarContrato(@Valid @ModelAttribute("contrato") ContratoRequest request, BindingResult result, Model model) {
        try {
            if (request.getEmpleado() == null) {
                result.rejectValue("empleado", null, "El empleado es requerido.");
            }
            if (request.getArea() == null) {
                result.rejectValue("area", null, "El area es requerido.");
            }
            if (request.getModalidad() == null) {
                result.rejectValue("modalidad", null, "La modalidad es requerida.");
            }
            if (request.getJornada() == null) {
                result.rejectValue("jornada", null, "La jornada es requerida.");
            }
            if (request.getFechaEmision() == null) {
                result.rejectValue("fechaEmision", null, "La fecha de emision es requerida.");
            }
            if (request.getFechaInicio() == null) {
                result.rejectValue("fechaInicio", null, "La fecha de inicio es requerida.");
            }

            if (result.hasErrors()){
                model.addAttribute("hayErrores", true);
                model.addAttribute("contrato", request);
                model.addAttribute("empleados", empleadoService.getAll());
                model.addAttribute("areas", areaService.listAllAreas());
                model.addAttribute("jornadas", jornadaService.listAllJornadas());
                model.addAttribute("modalidades", empleadoService.getModalidadesContrato());
                return "contratos/AgregarContrato";
            }

            int idEmpleado = request.getEmpleado().getId();

            boolean contratoActivo = contratoService.contratoIsActivo(idEmpleado);
            if (contratoActivo){
                Contrato contrato = contratoService.findByEmpleado(idEmpleado);

                contrato.setFechaFin(LocalDate.now());
                contratoService.updateContrato(contrato);
                empleadoService.desactivar(idEmpleado);
            }

            contratoService.addContrato(request);
            empleadoService.activar(idEmpleado);

            return "redirect:/empleados";
        } catch (Exception e) {
            System.out.println(" agregarContrato() => " + e.getMessage());
            e.printStackTrace();
        }
        return "redirect:/empleados";
    }
}
