package com.unu.repository;

import com.unu.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("arearepository")
public interface AreaRepository extends JpaRepository<Area, Serializable> {

}
