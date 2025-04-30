package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.ModalidadContrato;

@Repository("modalidadrepository")
public interface ModalidadeContratoRepository extends JpaRepository<ModalidadContrato,Serializable>{

}
