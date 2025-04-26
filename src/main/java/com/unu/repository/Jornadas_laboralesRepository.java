package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.Jornadas_laborales;

@Repository("jornadasrepository")
public interface Jornadas_laboralesRepository extends JpaRepository<Jornadas_laborales,Serializable>{

}
