package com.unu.repository;

import com.unu.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("loginrepository")
public interface LoginRepository extends JpaRepository<Login, Serializable> {


    @Query("SELECT u FROM Login u  WHERE u.usurio=?1 and u.contraseña=?2 ")
    public Login user_contra(String nombre, String contra);

}
