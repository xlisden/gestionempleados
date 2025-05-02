package com.unu.repository;

import com.unu.entity.Facturacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("facturacionrepository")
public interface FacturacionRepository extends JpaRepository<Facturacion, Serializable> {

}
