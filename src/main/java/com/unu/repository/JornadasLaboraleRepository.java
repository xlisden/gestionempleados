package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.JornadasLaborale;

@Repository("jornadasrepository")
public interface JornadasLaboraleRepository extends JpaRepository<JornadasLaborale,Serializable>{

}
