package com.unu.repository;

import com.unu.entity.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("entidadrepository")
public interface BancoRepository extends JpaRepository<Banco, Serializable> {


}
