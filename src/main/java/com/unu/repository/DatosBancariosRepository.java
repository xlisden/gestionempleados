package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.DatosBancarios;

@Repository("datosrepository")
public interface DatosBancariosRepository extends JpaRepository<DatosBancarios,Serializable>{
	
	
}
