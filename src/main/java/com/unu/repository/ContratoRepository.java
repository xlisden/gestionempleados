package com.unu.repository;

import com.unu.entity.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("contratorepository")
public interface ContratoRepository extends JpaRepository<Contrato, Serializable> {

    @Query("SELECT c FROM Contrato c WHERE c.empleado.id = ?1 ORDER BY c.fechaEmision DESC LIMIT 1")
    public Contrato findByEmpleado(int idEmpleado);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Contrato c WHERE c.empleado.id = ?1 AND c.activo IS true")
    public boolean contratoIsActivo(int idEmpleado);

    @Modifying
    @Query("UPDATE Contrato c SET c.activo = false WHERE c.id = ?1")
    public void desactivar(int id);

    @Modifying
    @Query("UPDATE Contrato c SET c.activo = true WHERE c.id = ?1")
    public void activar(int id);

    @Query("SELECT c FROM Contrato c WHERE c.area.id = ?1 AND c.activo IS true")
    public List<Contrato> getContratoByArea(int idArea);

}