package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.Empleado;

@Repository("empleadorepository")
public interface EmpleadoRepository extends JpaRepository<Empleado,Serializable>{
	
	//falta por nombre, dni, y codigo
	
}
