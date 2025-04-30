package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.JornadaLaboral;

@Repository("jornadarepository")
public interface JornadaLaboralRepository extends JpaRepository<JornadaLaboral,Serializable>{

}
