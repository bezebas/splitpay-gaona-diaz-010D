package com.splitpay.pagos.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.splitpay.pagos.model.Pagos;

import java.util.List;

public interface RepositoryPagos extends JpaRepository<Pagos, String> {
    List<Pagos> findByEventoId(String eventoId);
}