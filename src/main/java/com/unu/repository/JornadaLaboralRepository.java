package com.unu.repository;

import com.unu.entity.JornadaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("jornadarepository")
public interface JornadaLaboralRepository extends JpaRepository<JornadaLaboral, Serializable> {

}
