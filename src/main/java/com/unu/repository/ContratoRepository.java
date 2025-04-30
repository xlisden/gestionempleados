package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unu.entity.Contrato;

@Repository("contratorepository")
public interface ContratoRepository extends JpaRepository<Contrato,Serializable> {

    @Query("SELECT c FROM Contrato c WHERE c.empleado.id = ?1")
    public Contrato findByEmpleado(int idEmpleado);

}