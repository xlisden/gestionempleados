package com.unu.controller;

import com.google.gson.Gson;
import com.unu.controller.request.EditarEmpleadoRequest;
import com.unu.controller.request.InsertarEmpleadoRequest;
import com.unu.entity.Contrato;
import com.unu.entity.CuentaBancaria;
import com.unu.entity.Empleado;
import com.unu.entity.Login;
import com.unu.entity.dto.*;
import com.unu.entity.enums.FacturacionHelper;
import com.unu.service.*;
import com.unu.serviceimpl.CuentaBancariaImpl;
import com.unu.serviceimpl.FacturacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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


    @Autowired
    @Qualifier("contratoservice")
    private ContratoService contratoService;

    @Autowired
    @Qualifier("datosservice")
    private CuentaBancariaImpl cuentaService;

    @Autowired
    @Qualifier("facturacionservice")
    private FacturacionServiceImpl facturacionService;


    @GetMapping({"/", ""})
    public ModelAndView empleados(@RequestParam(required = false) String nombre,
                                  @RequestParam(required = false) String jornad,
                                  @RequestParam(required = false) String areaa) throws Exception {

        if (logiservice.tiempoSesion()) {
//            ModelAndView mav = new ModelAndView("empleados/EmpleadosList");
            ModelAndView mav = new ModelAndView("empleados/empleados");
            LocalDate hoy = LocalDate.now();
            List<EmpleadoDto> empleados = new ArrayList<>();

            try {
                empleados = empleadoService.listAllEmpleados(nombre, areaa, jornad);
                if (hoy.getDayOfMonth() >= FacturacionHelper.diaPago) {
                    for (EmpleadoDto e : empleados) {
                        if (e.isActivo() && !facturacionService.empleadoPagado(e.getId())) {
                            empleadoService.emitirRecibo(null, e.getId(), FacturacionHelper.isBonificacion(hoy));
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("listEmpleados() -> " + e.getMessage());
                e.printStackTrace();
            }

            mav.addObject("empleados", empleados);
            mav.addObject("areas", areaService.listAllAreas());
            mav.addObject("jornadas", jornadaService.listAllJornadas());

            return mav;
        }
        return new ModelAndView("Logeo").addObject("login", new Login());
    }

    @GetMapping("/{id}")
    public ModelAndView detalle(@PathVariable int id) throws Exception {
        if (logiservice.tiempoSesion()) {
            ModelAndView mav = new ModelAndView("empleados/EmpleadoDetalle");
            EmpleadoDetalleDto empleado = new EmpleadoDetalleDto();
            CuentaBancariaDto cuenta = new CuentaBancariaDto();
            ContratoDto contrato = new ContratoDto();

            try {
                empleado = empleadoService.getEmpleado(id);
                cuenta = empleadoService.getCuentaBancaria(id);
                contrato = empleadoService.getContratoDto(id);
            } catch (Exception e) {
                System.out.println("fallo en la captura de datos: " + e.getMessage());
            }
            mav.addObject("id",id);
            mav.addObject("empleado", empleado);
            mav.addObject("cuentaBancaria", cuenta);
            mav.addObject("contrato", contrato);

            return mav;
        }
        return new ModelAndView("Logeo").addObject("login", new Login());
    }

    /* Insertar */

    @GetMapping("/agregar")
    public ModelAndView insertarGetDatos() throws Exception {
        ModelAndView mav = new ModelAndView("empleados/AgregarEmpleado");
        if (logiservice.tiempoSesion()) {
            mav.addObject("estadosciviles", empleadoService.getEstadosCiviles());
            mav.addObject("areas", areaService.listAllAreas());
            mav.addObject("jornadas", jornadaService.listAllJornadas());
            mav.addObject("modalidades", empleadoService.getModalidadesContrato());
            mav.addObject("bancos", empleadoService.getBancos());
            mav.addObject("empleado", new InsertarEmpleadoRequest());
            mav.addObject("hayErrores", false);

            return mav;
        }
        return new ModelAndView("Logeo").addObject("login", new Login());
    }

    @PostMapping("/agregar")
    public String insertarPostDatos(@ModelAttribute InsertarEmpleadoRequest empleado,
                                    @RequestParam(name = "file", required = false) MultipartFile foto, BindingResult result, Model model) {

        try {
            if (empleadoService.dniExists(empleado.getDni())) {
//                result.addError(new ObjectError("dni", "El DNI ya le pertenece a otro empleado."));
//                result.rejectValue("dni", "error.dni", "El DNI ya le pertenece a otro empleado.");
                result.addError(new FieldError("dni", "dni", empleado.getDni(), false, null, null, "El DNI ya le pertenece a otro empleado."));
                System.err.println(empleado.getDni() + " ya existe.");
                model.addAttribute("estadosciviles", empleadoService.getEstadosCiviles());
                model.addAttribute("areas", areaService.listAllAreas());
                model.addAttribute("jornadas", jornadaService.listAllJornadas());
                model.addAttribute("modalidades", empleadoService.getModalidadesContrato());
                model.addAttribute("bancos", empleadoService.getBancos());
                model.addAttribute("empleado", empleado);
                model.addAttribute("hayErrores", true);
                return "empleados/AgregarEmpleado";
            }

            Empleado nuevoEmpleado = empleadoService.empleadoBruto(empleado, foto);
            Contrato contrato = contratoService.addTipoM(new Contrato(0, nuevoEmpleado, empleado.getArea(), empleado.getFechaEmision()
                    , empleado.getModalidadContrato(), LocalDate.now(), null, empleado.getJornadaLaboral()));
            CuentaBancaria cuentaBancaria = cuentaService.addDatos(new CuentaBancaria(0, empleado.getBanco(), empleado.getCci(), nuevoEmpleado));

            return "redirect:/empleados";
        } catch (Exception e) {
            System.out.println(" nada master: " + e.getMessage());
            return "redirect:/empleados/agregar";
        }
    }

    /* Editar */

    @GetMapping("/editar/{id}")
    public ModelAndView editarGetDatos(@PathVariable int id) throws Exception {
        if (logiservice.tiempoSesion()) {
            ModelAndView mav = new ModelAndView("empleados/EditarEmpleado");

            try {
                mav.addObject("idEmpleado", id);
                mav.addObject("idContrato", contratoService.findByEmpleado(id).getId());
                mav.addObject("idCuenta", cuentaService.getByEmpleado(id).getId());

                mav.addObject("estadosciviles", empleadoService.getEstadosCiviles());
                mav.addObject("areas", areaService.listAllAreas());
                mav.addObject("jornadas", jornadaService.listAllJornadas());
                mav.addObject("modalidades", empleadoService.getModalidadesContrato());
                mav.addObject("bancos", empleadoService.getBancos());
                mav.addObject("empleado", empleadoService.empleadoEditar(empleadoService.getEmpleadoNormal(id),
                                                                                        contratoService.findByEmpleado(id),
                                                                                        cuentaService.getByEmpleado(id)));
            } catch (Exception e) {
                System.out.println("editarGetDatos() => " + e.getMessage());
                e.printStackTrace();

                mav.addObject("idContrato", new Contrato());
                mav.addObject("idCuenta", new CuentaBancaria());
            }
            return mav;
        }
        return new ModelAndView("Logeo").addObject("login", new Login());
    }

    @PostMapping("/editar")
    public String editarPostDatos(@ModelAttribute EditarEmpleadoRequest empleado,
                                  @RequestParam(name = "file", required = false) MultipartFile foto,
                                  @RequestParam(required = false) int idEmpleado,
                                  @RequestParam(required = false) int idContrato,
                                  @RequestParam(required = false) int idCuenta) {
        try {
            Empleado nuevoEmpleado = empleadoService.empleadoEditarPost(empleado, foto, idEmpleado);

            contratoService.updateContrato(new Contrato(idContrato, nuevoEmpleado, empleado.getArea(), empleado.getFechaEmision()
                    , empleado.getModalidadContrato(),empleado.getFechaInicio(), null, empleado.getJornadaLaboral()));
            cuentaService.updateDatos(new CuentaBancaria(idCuenta, empleado.getBanco(), empleado.getCci(), nuevoEmpleado));

            return "redirect:/empleados";
        } catch (Exception e) {
            System.out.println(" nada master: " + e.getMessage());
            return "redirect:/empleados";
        }
    }


    /*@PutMapping("/editar") //PutMapping que es eso?
    private String editar(@ModelAttribute EditarEmpleadoRequest empleadoRequest, BindingResult bindingResult) {
        return "";
    }*/





    /* pagar al empleado */

    @GetMapping("/emitir-recibo/{id}")
    public ModelAndView getEmitirRecibo(@PathVariable int id) throws Exception {
        ModelAndView mav = new ModelAndView("empleados/EmitirRecibo");
        try {
            FacturacionDto facturacion = empleadoService.getDatosEmitirRecibo(id);
            List<FacturacionDto> facturas = facturacionService.listByEmpleado(id);

            String facturacionJson = new Gson().toJson(facturacion);

            mav.addObject("facturacion", facturacion);
            mav.addObject("facturas", facturas);
            mav.addObject("facturacionJson", facturacionJson);
            mav.addObject("bonificacion", FacturacionHelper.isBonificacion());
        } catch (Exception e) {
            System.out.println("getEmitirRecibo() => " + e.getMessage());
        }
        return mav;
    }

    @PostMapping("/emitir-recibo/{id}")
    public ModelAndView emitirRecibo(@PathVariable int id, @ModelAttribute("facturacion") FacturacionDto facturacionDto) throws Exception {
        ModelAndView mav = new ModelAndView("empleados/EmitirRecibo");
        FacturacionDto facturacion = new FacturacionDto();
        List<FacturacionDto> facturas = new ArrayList<>();
        String facturacionJson = new Gson().toJson("");
        try {
            facturas = facturacionService.listByEmpleado(id);

            if (facturacionService.empleadoPagado(id)) {
                throw new Exception("El empleado ya fue pagado.");
            }

            facturacion = empleadoService.emitirRecibo(facturacionDto, id, FacturacionHelper.isBonificacion());
            facturacionJson = new Gson().toJson(facturacion);
            mav.addObject("mensaje", "Recibo emitido exitosamente a " + facturacion.getEmpleado() + " (S/." + facturacion.getSueldoNeto() + ").");

        } catch (Exception e) {
            System.out.println("getEmitirRecibo() => " + e.getMessage());
            mav.addObject("error", "Error al emitir el recibo a " + facturacionDto.getEmpleado() + " (S/." + facturacionDto.getSueldoNeto() + ").");
        }

        mav.addObject("facturacionJson", facturacionJson);
        mav.addObject("facturacion", facturacionDto);
        mav.addObject("facturas", facturas);
        mav.addObject("bonificacion", FacturacionHelper.isBonificacion());

        return mav;
    }

    /* desactivar */

    @GetMapping("/desactivar/{id}") /*es un PATCH, pero por efectos practicos GET*/
    public String deasctivar(@PathVariable int id) {
        empleadoService.desactivar(id);
        return "redirect:/empleados";
    }

    @GetMapping("/activar/{id}") /*es un PATCH, pero por efectos practicos GET*/
    public String activar(@PathVariable int id) {
        empleadoService.activar(id);
        return "redirect:/empleados";
    }


}
