package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.JornadaLaboral;

@Repository("jornadasrepository")
public interface JornadasLaboraleRepository extends JpaRepository<JornadaLaboral,Serializable>{

}
