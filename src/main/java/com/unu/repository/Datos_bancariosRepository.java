package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.Datos_bancarios;

@Repository("datosrepository")
public interface Datos_bancariosRepository extends JpaRepository<Datos_bancarios,Serializable>{
	
	
}
