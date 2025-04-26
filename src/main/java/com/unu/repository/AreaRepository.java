package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.Areas;

@Repository("arearepository")
public interface AreaRepository extends JpaRepository<Areas,Serializable>{
	
}
