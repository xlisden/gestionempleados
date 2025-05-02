package com.unu.serviceimpl;

import com.unu.entity.JornadaLaboral;
import com.unu.repository.JornadaLaboralRepository;
import com.unu.service.JornadaLaboralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jornadaservice")
public class JornadaLaboralServiceImpl implements JornadaLaboralService {
    @Autowired
    @Qualifier("jornadarepository")
    private JornadaLaboralRepository jordrepo;

    @Override
    public List<JornadaLaboral> listAllJornadas() {
        return jordrepo.findAll();
    }

    @Override
    public JornadaLaboral addJord(JornadaLaboral jord) {
        return jordrepo.save(jord);
    }

    @Override
    public JornadaLaboral getJord(long id) throws Exception {
        return jordrepo.findById(id).orElseThrow(() -> new Exception("La Jornada Laboral no existe."));
    }

    @Override
    public void updateJord(JornadaLaboral jord) {
        jordrepo.save(jord);
    }

    @Override
    public void deleteJord(long id) {
        jordrepo.deleteById(id);
    }


}
