package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.Estados_civiles;

@Repository("estadosrepository")
public interface Estados_civilesRepository extends JpaRepository<Estados_civiles,Serializable>{
	
	
}
