package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.EstadosCiviles;

@Repository("estadosrepository")
public interface EstadosCivilesRepository extends JpaRepository<EstadosCiviles,Serializable>{
	
	
}
