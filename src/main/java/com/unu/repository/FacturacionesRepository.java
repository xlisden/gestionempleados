package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.Facturaciones;

@Repository("facturasrepository")
public interface FacturacionesRepository extends JpaRepository<Facturaciones,Serializable>{
	
}
