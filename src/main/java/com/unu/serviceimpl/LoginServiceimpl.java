package com.unu.serviceimpl;

import com.unu.entity.Login;
import com.unu.repository.LoginRepository;
import com.unu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service("loginservice")
public class LoginServiceimpl implements LoginService {

    @Autowired
    @Qualifier("loginrepository")
    private LoginRepository logrepo;

    @Override
    public List<Login> listAllLogin(String logi) {
        // TODO Auto-generated method stub
        return logrepo.findAll();
    }

    @Override
    public Login addLogin(Login logi) {
        return logrepo.save(logi);
    }

    @Override
    public Login getLogin(long id) throws Exception {
        return logrepo.findById(id).orElseThrow(() -> new Exception("El Login para editar no existe"));
    }

    @Override
    public void updateLogin(Login logi) {
        logrepo.save(logi);
    }

    @Override
    public void deleteLogin(long id) {
        logrepo.deleteById(id);
    }

    @Override
    public boolean validacion(String us, String ps) {
        try {
            if (logrepo.user_contra(us, ps) != null) {
                Login log = getLogin(1);
                logrepo.save(new Login(1, us, ps, log.getEmpleado(), true, LocalDateTime.now()));
                System.out.println("------ sesion iniciada bien-----");
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    @Override
    public boolean tiempoSesion() throws Exception {
        try {
        	LocalDateTime sesion = getLogin(1).getHoras();
        	LocalDateTime ahora = LocalDateTime.now();

        	 int diferencia = (int) Math.abs(Duration.between(sesion, ahora).toMinutes());
            System.out.println("minutos en sesion: " + diferencia);
            if (diferencia <= 15 && getLogin(1).isEstado()) {
            	getLogin(1).setHoras(ahora);
                return true;
            }
        } catch (Exception e) {
            System.out.println("---- CERRAR SESION-------< HAY ERROR : " + e.getMessage());
            getLogin(1).setEstado(false);
            return false;
        }
        System.out.println("---- CERRAR SESION  ----< paso el tiempo");
        getLogin(1).setEstado(false);
        return false;
    }
}
