package com.unu.service;

import com.unu.entity.Login;

import java.util.List;

public interface LoginService {
    public abstract List<Login> listAllLogin(String logi);

    public abstract Login addLogin(Login logi);

    public abstract Login getLogin(long id) throws Exception;

    public abstract void updateLogin(Login logi);

    public abstract void deleteLogin(long id);

    public abstract boolean validacion(String us, String ps);

    public abstract boolean tiempoSesion()throws Exception;
}
