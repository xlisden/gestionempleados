package com.unu.serviceimpl;

import com.unu.entity.Area;
import com.unu.entity.Contrato;
import com.unu.entity.Empleado;
import com.unu.entity.dto.EmpleadoDto;
import com.unu.repository.AreaRepository;
import com.unu.repository.ContratoRepository;
import com.unu.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("areaservice")
public class AreaServiceImpl implements AreaService {

    @Autowired
    @Qualifier("arearepository")
    private AreaRepository arearepo;

    @Autowired
    @Qualifier("contratorepository")
    private ContratoRepository contratoRepository;

    @Override
    public List<Area> listAllAreas() {
        return arearepo.findAll();
    }

    @Override
    public Area addArea(Area area) {
        return arearepo.save(area);
    }

    @Override
    public Area getArea(long id) throws Exception {
        return arearepo.findById(id).orElseThrow(() -> new Exception("El Area no existe."));
    }

    @Override
    public void updateArea(Area area) {
        arearepo.save(area);
    }

    @Override
    public void deleteArea(long id) {
        arearepo.deleteById(id);
    }

    @Override
    public List<EmpleadoDto> getEmpleadosPorArea(int idArea) {
        List<EmpleadoDto> empleados = new ArrayList<>();
        List<Contrato> contratos = contratoRepository.getContratoByArea(idArea);

        for (Contrato c: contratos){
            Empleado e = c.getEmpleado();
            EmpleadoDto dto = new EmpleadoDto();

            dto.setId(e.getId());
            dto.setCod(e.getCod());
            dto.setNombreCompleto(e.getNombre() + " " + e.getApPaterno().toUpperCase() + " " + e.getApMaterno().toUpperCase());
            empleados.add(dto);
        }

        return empleados;
    }

}
