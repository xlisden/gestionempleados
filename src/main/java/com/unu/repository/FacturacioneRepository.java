package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.Facturacione;

@Repository("facturasrepository")
public interface FacturacioneRepository extends JpaRepository<Facturacione,Serializable>{
	
}
