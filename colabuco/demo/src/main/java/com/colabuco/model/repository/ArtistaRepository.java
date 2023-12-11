package com.colabuco.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colabuco.model.model.ArtistaModel;

@Repository
public interface ArtistaRepository extends JpaRepository<ArtistaModel, Long>{

}
