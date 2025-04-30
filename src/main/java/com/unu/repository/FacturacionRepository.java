package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.Facturacion;

@Repository("facturacionrepository")
public interface FacturacionRepository extends JpaRepository<Facturacion,Serializable>{
	
}
