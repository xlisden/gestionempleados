package com.unu.repository;

import com.unu.entity.Facturacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("facturacionrepository")
public interface FacturacionRepository extends JpaRepository<Facturacion, Serializable> {

    @Query("SELECT f FROM Facturacion f WHERE f.empleado.id = ?1")
    public List<Facturacion> findByEmpleado(int idEmpleado);

}
