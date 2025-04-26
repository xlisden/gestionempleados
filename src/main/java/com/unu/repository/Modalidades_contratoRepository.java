package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.Modalidades_contrato;

@Repository("modalidadrepository")
public interface Modalidades_contratoRepository extends JpaRepository<Modalidades_contrato,Serializable>{

}
