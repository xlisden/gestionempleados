package com.unu.serviceimpl;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unu.entity.Login;
import com.unu.repository.LoginRepository;
import com.unu.service.LoginService;

@Service("loginservice")
public class LoginServiceimpl implements LoginService{

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
	public void updatelogin(Login logi) {
		logrepo.save(logi);
	}

	@Override
	public void deletelogin(long id) {
		logrepo.deleteById(id);
	}
	 
	@Override
	public boolean validacion(String us, String ps) {
		try {
			if(logrepo.user_contra(us, ps)!=null) {
				Login log=getLogin(1);
				logrepo.save(new Login(1, us, ps, log.getEmpleado(),true,LocalTime.now()));
				System.out.println("------ sesion iniciada bien-----");
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}
