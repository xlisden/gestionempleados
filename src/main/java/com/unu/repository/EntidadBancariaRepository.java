package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.EntidadBancaria;

@Repository("entidadrepository")
public interface EntidadBancariaRepository extends JpaRepository<EntidadBancaria,Serializable>{

	
}
