package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.Banco;

@Repository("entidadrepository")
public interface EntidadBancariaRepository extends JpaRepository<Banco,Serializable>{

	
}
