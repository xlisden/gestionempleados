package com.unu.repository;

import com.unu.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("empleadorepository")
public interface EmpleadoRepository extends JpaRepository<Empleado, Serializable> {

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Empleado e WHERE e.dni = ?1")
    public boolean dniExists(String dni);

    @Modifying
    @Query("UPDATE Empleado e SET e.activo = false WHERE e.id = ?1")
    public void desactivar(int id);

    @Modifying
    @Query("UPDATE Empleado e SET e.activo = true WHERE e.id = ?1")
    public void activar(int id);

    @Query("SELECT e FROM Empleado e ORDER BY e.activo DESC")
    public List<Empleado> getAllOrdenActivo();

    /*
    SELECT e.* FROM empleado AS e, contrato AS c
				WHERE e.EmpId = c.ContId AND
					((null is null or LOWER(e.EmpNombre) LIKE '%173%')  OR 
					(null is null or LOWER(e.EmpDni) LIKE '%173%') OR 
					(null is null or LOWER(e.EmpApPaterno) LIKE '%173%')) AND
					(2 is null or c.ContArea = 2) AND
                    (2 is null or c.ContJLaboral = 2);
    */
    
    @Query("SELECT e,c from Empleado e, Contrato c where e.id=c.empleado.id "
    		+ "and ((?1 is null or lower(e.nombre) like  %?1%)"
    		+ "or (?1 is null or lower(e.dni) like  %?1%)"
    		+ "or (?1 is null or lower(e.apPaterno) like  %?1%)"
    		+ "or (?1 is null or lower(e.apMaterno) like  %?1%)"
    		+ "or (?1 is null or lower(e.cod) like  %?1%))"
    		+ "and (?2 is null or c.area.id=?2)"
    		+ "and (?3 is null or c.jornadaLaboral.id=?3)"
            + "ORDER BY e.activo DESC")
    public List<Empleado> listaxFiltro(String texto,String idArea,String jornada);

}