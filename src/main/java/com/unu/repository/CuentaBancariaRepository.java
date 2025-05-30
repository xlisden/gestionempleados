package com.unu.repository;

import com.unu.entity.CuentaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("cuentabancariarepository")
public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria, Serializable> {

    @Query("SELECT c FROM CuentaBancaria c WHERE c.empleado.id = ?1")
    public CuentaBancaria findByEmpleado(int id);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM CuentaBancaria c WHERE c.cci = ?1")
    public boolean cciExists(String cci);
    
}
