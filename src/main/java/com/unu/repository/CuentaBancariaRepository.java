package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unu.entity.CuentaBancaria;

@Repository("cuentabancariarepository")
public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria,Serializable>{
	
	@Query("SELECT d FROM CuentaBancaria d WHERE d.empleado.id=?1")
	public CuentaBancaria findDatosByEmpleado(int id);
}
