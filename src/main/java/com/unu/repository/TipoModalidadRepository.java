package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.TipoModalidad;

@Repository("tipomodalidadrepository")
public interface TipoModalidadRepository extends JpaRepository<TipoModalidad,Serializable> {
	
}
