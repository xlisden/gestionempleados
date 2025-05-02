package com.unu.repository;

import com.unu.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("empleadorepository")
public interface EmpleadoRepository extends JpaRepository<Empleado, Serializable> {

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Empleado e WHERE e.dni = ?1")
    public boolean dniExists(String dni);

    @Query("UPDATE Empleado e SET e.activo = false WHERE e.id = ?1")
    public void desactivar(int id);

    //falta por nombre, dni, y codigo

}
/*
@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Company c WHERE c.name = :companyName")

    @Query("SELECT c FROM Contrato c WHERE c.empleado.id = ?1")
    public Contrato findByEmpleado(int idEmpleado);
*/