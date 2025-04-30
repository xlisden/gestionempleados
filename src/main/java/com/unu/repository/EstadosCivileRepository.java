package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.EstadosCivile;

@Repository("estadosrepository")
public interface EstadosCivileRepository extends JpaRepository<EstadosCivile,Serializable>{
	
	
}
