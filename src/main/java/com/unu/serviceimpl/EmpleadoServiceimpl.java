package com.unu.serviceimpl;

import com.unu.controller.request.InsertarEmpleadoRequest;
import com.unu.entity.*;
import com.unu.entity.dto.ContratoDto;
import com.unu.entity.dto.CuentaBancariaDto;
import com.unu.entity.dto.EmpleadoDetalleDto;
import com.unu.entity.dto.EmpleadoDto;
import com.unu.repository.*;
import com.unu.service.EmpleadoService;
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

    @Override
    public List<EmpleadoDto> listAllEmpleados(String texto , String idArea,String idJornada) {
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
            dto.setAntiguedad(calcularAnitguedad(contrato.getFechaInicio()));
            dto.setActivo(emp.isActivo());

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
    public ContratoDto getContrato(int id) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Contrato contrato = contratoRepository.findByEmpleado(id);
        ContratoDto dto = new ContratoDto();

        dto.setId(contrato.getId());
        dto.setAntiguedad(calcularAnitguedad(contrato.getFechaEmision()));
        dto.setModalidadContrato(contrato.getModalidadCont().getNombre());
        dto.setFechaInicio(format.format(Date.valueOf(contrato.getFechaInicio())));
        dto.setFechaFin(null);//dto.setFechaFin(format.format(Date.valueOf(contrato.getFechaFin())));
        dto.setArea(contrato.getArea().getNombre());
        dto.setSueldoBasico(contrato.getArea().getSueldoBasico());
        dto.setJornadaLaboral(contrato.getJornadaLaboral().getNombre());

        return dto;
    }

    @Override
    public boolean dniExists(String dni) {
        return empleadoRepository.dniExists(dni);
    }

    @Override
    public void desactivar(int id) {
        empleadoRepository.desactivar(id);
    }

    // para no instanciar otro servicio, solo el de empleados
    public List<EstadoCivil> getEstadosCiviles(){
        return estCivilRepository.findAll();
    }

    @Override
    public List<ModalidadContrato> getModalidadesContrato() {
        return modContratoRepository.findAll();
    }

    public List<Banco> getBancos() {
        return bancoRepository.findAll();
    }

    public String calcularAnitguedad(LocalDate inicio) {
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
    	if(tex==null || tex.equals("")) return null;
    	else return tex;
    }
    
    
    public Empleado empleadoBruto(InsertarEmpleadoRequest e, MultipartFile foto) {
    	Empleado nuevo = addEmple(new Empleado(0, null, e.getDni(),e.getNombre(), e.getApPaterno(),
    			e.getApMaterno(),e.isGenero(),e.getEstadoCivil(),e.getFechaNacimiento(),null,true));

    	nuevo.setCod(String.format("E%04d", nuevo.getId()));
    	nuevo.setFoto(nombreFoto(foto, nuevo));
    	return nuevo;
    }
    
    
    
    public String nombreFoto(MultipartFile foto,Empleado empleado) {
    	
    	if (!foto.isEmpty()) {
	    	try {
				String originalFilename = foto.getOriginalFilename();
		        String extension = "";
		        int i = originalFilename.lastIndexOf('.');
		        if (i > 0) {
		            extension = originalFilename.substring(i);
		        }
		        if(extension.equals(".jpg")||extension.equals(".png")||extension.equals(".webp")||extension.equals(".svg")) {
		        	Path filePath = Paths.get("src/main/resources/static/img/" + empleado.getCod()+extension);
		        	Files.copy(foto.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		        	return empleado.getCod()+extension;
		        }else {
		        	System.out.println("formato no valida");
		        	return "ddd.png";
		        }	    		
			} catch (Exception e) {
				System.out.println("error al cargar la foto: "+e.getMessage());
				return "ddd.png";
			}
    	}else {
    		System.out.println("foto por deafault asignada");
    		return "ddd.png";
    	}
    }
    
    
    
}	
