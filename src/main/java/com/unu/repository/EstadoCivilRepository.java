package com.unu.repository;

import com.unu.entity.EstadoCivil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("estadosrepository")
public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Serializable> {


}
