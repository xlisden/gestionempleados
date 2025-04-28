package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.Empleados;

@Repository("empleadorepository")
public interface EmpleadosRepository extends JpaRepository<Empleados,Serializable>{
	
	//falta por nombre, dni, y codigo
	
}
