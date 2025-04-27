package com.unu.service;

import java.util.List;

import com.unu.entity.Login;

public interface LoginService {
	public abstract List<Login> listAllLogin(String logi);
	public abstract Login addLogin(Login logi);
	public abstract Login getLogin(long	id)throws Exception;
	public abstract void updatelogin(Login logi);
	public abstract void deletelogin(long id);
	public abstract boolean validacion(String us,String ps);
}
