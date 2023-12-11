package com.colabuco.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.colabuco.model.model.CarrinhoDeComprasModel;

@Repository
public interface CarrinhoDeComprasRepository extends JpaRepository<CarrinhoDeComprasModel, Long>{

}