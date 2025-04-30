package com.unu.repository;

import java.io.Serializable;

import com.unu.entity.EstadoCivil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("estadosrepository")
public interface EstadoCivilRepository extends JpaRepository<EstadoCivil,Serializable>{
	
	
}
