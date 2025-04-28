package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.JornadasLaborales;

@Repository("jornadasrepository")
public interface JornadasLaboralesRepository extends JpaRepository<JornadasLaborales,Serializable>{

}
