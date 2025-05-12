package com.unu.serviceimpl;

import com.unu.controller.request.EditarEmpleadoRequest;
import com.unu.controller.request.InsertarEmpleadoRequest;
import com.unu.entity.*;
import com.unu.entity.dto.*;
import com.unu.entity.enums.FacturacionHelper;
import com.unu.repository.*;
import com.unu.service.EmpleadoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("empleadosservice")
public class EmpleadoServiceimpl implements EmpleadoService {

    @Autowired
    @Qualifier("empleadorepository")
    private EmpleadoRepository empleadoRepository;

    @Autowired
    @Qualifier("contratorepository")
    private ContratoRepository contratoRepository;

    @Autowired
    @Qualifier("cuentabancariarepository")
    private CuentaBancariaRepository cuentabancariarepository;

    @Autowired
    @Qualifier("estadosrepository")
    private EstadoCivilRepository estCivilRepository;

    @Autowired
    @Qualifier("modalidadcontratorepository")
    private ModalidadContratoRepository modContratoRepository;

    @Autowired
    @Qualifier("bancorepository")
    private BancoRepository bancoRepository;

    @Autowired
    @Qualifier("facturacionrepository")
    private FacturacionRepository factrepo;

    @Autowired
    private FacturacionRepository facturacionrepository;

    @Override
    public List<EmpleadoDto> listAllEmpleados(String texto, String idArea, String idJornada) {
        List<Empleado> lista = empleadoRepository.listaxFiltro(isNull(texto), isNull(idArea), isNull(idJornada));

        List<EmpleadoDto> empleados = new ArrayList<EmpleadoDto>();
        for (Empleado emp : lista) {
            Contrato contrato = contratoRepository.findByEmpleado(emp.getId());
            EmpleadoDto dto = new EmpleadoDto();

            dto.setId(emp.getId());
            dto.setCod(emp.getCod());
            dto.setNombreCompleto(emp.getNombre() + " " + emp.getApPaterno().toUpperCase() + " " + emp.getApMaterno().toUpperCase());
            dto.setArea((contrato.getArea() == null) ? "" : contrato.getArea().getNombre());
            dto.setModalidadContrato((contrato.getModalidadCont() == null) ? "" : contrato.getModalidadCont().getNombre());
            dto.setJornadaLaboral((contrato.getJornadaLaboral() == null) ? "" : contrato.getJornadaLaboral().getNombre());
            dto.setAntiguedad(calcularAnitguedad(contrato.getFechaInicio(), emp.isActivo()));
            dto.setActivo(emp.isActivo());
            dto.setFoto(emp.getFoto());

            empleados.add(dto);
        }
        return empleados;
    }

    @Override
    public Empleado addEmple(Empleado emple) {
        return empleadoRepository.save(emple);
    }

    @Override
    public EmpleadoDetalleDto getEmpleado(int id) throws Exception {
        Empleado emp = empleadoRepository.findById(id).orElseThrow(() -> new Exception("El Empleado no existe."));
        EmpleadoDetalleDto dto = new EmpleadoDetalleDto();

        dto.setId(emp.getId());
        dto.setCod(emp.getCod());
        dto.setDni(emp.getDni());
        dto.setNombre(emp.getNombre());
        dto.setApPaterno(emp.getApPaterno());
        dto.setApMaterno(emp.getApMaterno());
        dto.setGenero((emp.isGenero()) ? "Femenino" : "Masculino");
        dto.setEstadoCivil((emp.getEstadoCivil() == null) ? "" : emp.getEstadoCivil().getNombre());
        dto.setEdad(calcularEdad(emp.getFechaNac()));
        dto.setEstado(emp.isActivo() ? "Activo" : "Inactivo");
        dto.setActivo(emp.isActivo());
        dto.setFoto(emp.getFoto());

        return dto;
    }

    @Override
    public void updateEmple(Empleado emple) {
        empleadoRepository.save(emple);
    }

    @Override
    public void deleteEmple(long id) {
        empleadoRepository.deleteById(id);
    }

    @Override
    public CuentaBancariaDto getCuentaBancaria(int id) throws Exception {
        CuentaBancaria cuenta = cuentabancariarepository.findByEmpleado(id);
        CuentaBancariaDto dto = new CuentaBancariaDto();

        dto.setId(cuenta.getId());
        dto.setBanco(cuenta.getBanco().getNombre());
        dto.setCci(cuenta.getCci());

        return dto;
    }

    @Override
    public ContratoDto getContratoDto(int id) throws Exception {
        //SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Contrato contrato = contratoRepository.findByEmpleado(id);
        ContratoDto dto = new ContratoDto();

        dto.setId(contrato.getId());
        dto.setAntiguedad(calcularAnitguedad(contrato.getFechaInicio(), contrato.getEmpleado().isActivo()));
        dto.setModalidadContrato(contrato.getModalidadCont().getNombre());
        dto.setFechaInicio((contrato.getFechaInicio()==null)?"-":contrato.getFechaInicio()+"");
        dto.setFechaFin((contrato.getFechaFin()==null)?"-":contrato.getFechaFin()+"");
        dto.setArea(contrato.getArea().getNombre());
        dto.setSueldoBasico(contrato.getArea().getSueldoBasico());
        dto.setJornadaLaboral(contrato.getJornadaLaboral().getNombre());

        return dto;
    }

    @Override
    public FacturacionDto emitirRecibo(FacturacionDto facturacionDto, int id, boolean bonificacion) throws Exception {
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Contrato contrato = contratoRepository.findByEmpleado(id);

        if (contrato == null)
            throw new Exception("El contrato no existe.");

        Empleado empleado = contrato.getEmpleado();
        if (empleado == null)
            throw new Exception("El empleado no existe.");
        if (!empleado.isActivo())
            throw new Exception("El empleado no tiene un contrato activo.");

        double sueldo = (bonificacion) ? contrato.getArea().getSueldoBasico() + FacturacionHelper.bonitificacion : contrato.getArea().getSueldoBasico();
        LocalDate fecha = (facturacionDto == null) ? LocalDate.now() : LocalDate.parse(facturacionDto.getFechaPago());

        Facturacion facturacion = new Facturacion(fecha, sueldo, empleado);
        facturacionrepository.save(facturacion);

        FacturacionDto dto = new FacturacionDto();

        dto.setIdEmpleado(empleado.getId());
        dto.setCod(empleado.getCod());
        dto.setDni(empleado.getDni());
        dto.setEmpleado(empleado.getNombre() + " " + empleado.getApPaterno().toUpperCase() + " " + empleado.getApMaterno().toUpperCase());
        dto.setFechaPago((fecha==null)?"-":fecha+"");
        dto.setSueldoBruto(sueldo);
        dto.setBonificacion(0.0);
        dto.setSueldoNeto(sueldo);

        return dto;
    }

    public FacturacionDto getDatosEmitirRecibo(int id) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Contrato contrato = contratoRepository.findByEmpleado(id);

        if (contrato == null)
            throw new Exception("El contrato no existe.");

        Empleado empleado = contrato.getEmpleado();
        if (empleado == null)
            throw new Exception("El empleado no existe.");
//        if (!empleado.isActivo())
//            throw new Exception("El empleado no tiene un contrato activo.");

        double sueldo = contrato.getArea().getSueldoBasico();
        FacturacionDto dto = new FacturacionDto();

        dto.setIdEmpleado(empleado.getId());
        dto.setCod(empleado.getCod());
        dto.setDni(empleado.getDni());
        dto.setEmpleado(empleado.getNombre() + " " + empleado.getApPaterno().toUpperCase() + " " + empleado.getApMaterno().toUpperCase());
        dto.setFechaPago(format.format(Date.valueOf(LocalDate.now())));
        dto.setSueldoBruto(sueldo);
        dto.setBonificacion(0.0);
        dto.setSueldoNeto(sueldo);

        return dto;
    }

    @Override
    public boolean dniExists(String dni) {
        return empleadoRepository.dniExists(dni);
    }

    @Override
    @Transactional
    public void desactivar(int id) {
        Contrato contrato = contratoRepository.findByEmpleado(id);
        contrato.setFechaFin(LocalDate.now());
        contrato.setActivo(false);
        contratoRepository.save(contrato);
        empleadoRepository.desactivar(id);
    }

    @Override
    @Transactional
    public void activar(int id) {
        empleadoRepository.activar(id);
    }

    // para no instanciar otro servicio, solo el de empleados
    public List<EstadoCivil> getEstadosCiviles() {
        return estCivilRepository.findAll();
    }

    @Override
    public List<ModalidadContrato> getModalidadesContrato() {
        return modContratoRepository.findAll();
    }

    public List<Banco> getBancos() {
        return bancoRepository.findAll();
    }

    @Override
    public List<EmpleadoDto> listAllEmpleadosOrdenActivo() {
        List<Empleado> lista = empleadoRepository.getAllOrdenActivo();
        List<EmpleadoDto> empleados = new ArrayList<EmpleadoDto>();
        for (Empleado emp : lista) {
            Contrato contrato = contratoRepository.findByEmpleado(emp.getId());
            EmpleadoDto dto = new EmpleadoDto();
            dto.setId(emp.getId());
            dto.setCod(emp.getCod());
            dto.setNombreCompleto(emp.getNombre() + " " + emp.getApPaterno().toUpperCase() + " " + emp.getApMaterno().toUpperCase());
            dto.setArea((contrato.getArea() == null) ? "" : contrato.getArea().getNombre());
            dto.setModalidadContrato((contrato.getModalidadCont() == null) ? "" : contrato.getModalidadCont().getNombre());
            dto.setJornadaLaboral((contrato.getJornadaLaboral() == null) ? "" : contrato.getJornadaLaboral().getNombre());
            dto.setAntiguedad(calcularAnitguedad(contrato.getFechaInicio(), emp.isActivo()));
            dto.setActivo(emp.isActivo());

            empleados.add(dto);
        }
        return empleados;
    }

    public String calcularAnitguedad(LocalDate inicio, boolean activo) {
        if (!activo || inicio==null)
            return "";

        Period periodo = Period.between(inicio, LocalDate.now());
        int anios = periodo.getYears();
        int meses = periodo.getMonths();

        return anios + " años, " + meses + " meses";
    }

    public int calcularEdad(LocalDate fechaNac) {
        Period periodo = Period.between(fechaNac, LocalDate.now());

        return periodo.getYears();
    }


    public String isNull(String tex) { // reemplazar vacio por null sino devuelve lo mismo
        if (tex == null || tex.equals("")) return null;
        else return tex;
    }


    public Empleado empleadoBruto(InsertarEmpleadoRequest e, MultipartFile foto) {
        Empleado nuevo = addEmple(new Empleado(0, null, e.getDni(), e.getNombre(), e.getApPaterno(),
                e.getApMaterno(), e.isGenero(), e.getEstadoCivil(), e.getFechaNacimiento(), null, true));

        nuevo.setCod(String.format("E%04d", nuevo.getId()));
        nuevo.setFoto(nombreFoto(foto, nuevo));
        return nuevo;
    }


    public String nombreFoto(MultipartFile foto, Empleado empleado) {

        if (!foto.isEmpty()) {
            try {
                String originalFilename = foto.getOriginalFilename();
                String extension = "";
                int i = originalFilename.lastIndexOf('.');
                if (i > 0) {
                	extension = originalFilename.substring(i);
                }
                if (extension.equals(".jpg")|| extension.equals(".jpeg") || extension.equals(".png") || extension.equals(".webp") || extension.equals(".svg")) {
                    Path filePath = Paths.get("src/main/resources/static/img/" + empleado.getCod() + extension);
                    Files.copy(foto.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                    return empleado.getCod() + extension;
                } else {
                    System.out.println("formato no valida");
                    return "ddd.png";
                }
            } catch (Exception e) {
                System.out.println("error al cargar la foto: " + e.getMessage());
                return "ddd.png";
            }
        } else {
            System.out.println("foto por deafault asignada");
            return "ddd.png";
        }
    }

	@Override
	public Empleado getEmpleadoNormal(int id) throws Exception {
		return  empleadoRepository.findById(id).orElseThrow(() -> new Exception("El Empleado no existe."));
	}

	@Override
	public EditarEmpleadoRequest empleadoEditar(Empleado empe, Contrato contrato, CuentaBancaria cuenta) {
		EditarEmpleadoRequest e = new EditarEmpleadoRequest();
		e.setApMaterno(empe.getApMaterno());
		e.setApPaterno(empe.getApPaterno());
		e.setArea(contrato.getArea());
		e.setBanco(cuenta.getBanco());
		e.setCci(cuenta.getCci());
		e.setDni(empe.getDni());
		e.setEstadoCivil(empe.getEstadoCivil());
		e.setFechaEmision(contrato.getFechaEmision());
		e.setFechaFin(contrato.getFechaFin());
		e.setFechaInicio(contrato.getFechaInicio());
		e.setFechaNacimiento(empe.getFechaNac());
		e.setFoto(empe.getFoto());
		e.setGenero(empe.isGenero());
		e.setJornadaLaboral(contrato.getJornadaLaboral()); 
		e.setModalidadContrato(contrato.getModalidadCont());
		e.setNombre(empe.getNombre());
		return e;
	}

	@Override
	public Empleado empleadoEditarPost(EditarEmpleadoRequest empe, MultipartFile foto,int id) {
		Empleado actualizado= null;
		try {
            LocalDate fechaNac = empe.getFechaNacimiento();
            if (empe.getFechaNacimiento() == null){
                Empleado emp = empleadoRepository.findById(id).orElseThrow(() -> new Exception("El Empleado no existe."));
                fechaNac = emp.getFechaNac();
            }
			 actualizado = new Empleado(id,getEmpleado(id).getCod(),empe.getDni(),empe.getNombre(),empe.getApPaterno(),empe.getApMaterno(),empe.isGenero(),
				empe.getEstadoCivil(),empe.getFechaNacimiento(),getEmpleado(id).getFoto(),getEmpleado(id).isActivo());
			 if(!foto.isEmpty())
				 actualizado.setFoto(nombreFoto(foto, actualizado));
			 updateEmple(actualizado);
			 return actualizado;
		} catch (Exception e) {
			System.out.println(" no se nada ya ,FALLO EDITAR EMPLEADO POST: "+e.getMessage());
			return actualizado;
		}		
	}

    public List<EmpleadoDtoSelect> getAll(){
        List<EmpleadoDtoSelect> empleados = new ArrayList<>();
        List<Empleado> lista = empleadoRepository.getAllOrdenActivo();

        for (Empleado e: lista){
            EmpleadoDtoSelect dto = new EmpleadoDtoSelect();

            dto.setId(e.getId());
            dto.setNombreCompleto(e.getNombre() + " " + e.getApPaterno().toUpperCase() + " " + e.getApMaterno().toUpperCase());
            empleados.add(dto);
        }

        return empleados;
    }

    public String getFechaNacimiento(int id) throws Exception {
        Empleado emp = empleadoRepository.findById(id).orElseThrow(() -> new Exception("El Empleado no existe."));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(Date.valueOf(emp.getFechaNac()));
    }


}	
