package com.unu.repository;

import com.unu.entity.ModalidadContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("modalidadcontratorepository")
public interface ModalidadContratoRepository extends JpaRepository<ModalidadContrato, Serializable> {

}
