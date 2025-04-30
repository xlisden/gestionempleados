package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.ModalidadesContrato;

@Repository("modalidadrepository")
public interface ModalidadeContratoRepository extends JpaRepository<ModalidadesContrato,Serializable>{

}
