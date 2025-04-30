package com.unu.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unu.entity.DatosBancario;

@Repository("datosrepository")
public interface DatosBancarioRepository extends JpaRepository<DatosBancario,Serializable>{
	
	@Query("SELECT d FROM DatosBancario d WHERE d.empleado.idEmpleado=?1")
	public DatosBancario findDatosByEmpleado(int id);
}
