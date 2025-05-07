package com.unu.repository;

import com.unu.entity.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("contratorepository")
public interface ContratoRepository extends JpaRepository<Contrato, Serializable> {

    @Query("SELECT c FROM Contrato c WHERE c.empleado.id = ?1 ORDER BY c.fechaEmision DESC LIMIT 1")
    public Contrato findByEmpleado(int idEmpleado);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Contrato c WHERE c.empleado.id = ?1 AND c.fechaFin is not null")
    public boolean contratoIsActivo(int idEmpleado);

}