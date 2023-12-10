package com.colabuco.model.repository;

import com.colabuco.model.model.ClienteModel;
import com.colabuco.model.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel,String> {
    public Optional<PedidoModel> findById(String id);

}
