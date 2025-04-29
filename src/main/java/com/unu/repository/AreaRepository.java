package com.unu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unu.entity.Area;

@Repository("arearepository")
public interface AreaRepository extends JpaRepository<Area,Serializable>{
	
}
