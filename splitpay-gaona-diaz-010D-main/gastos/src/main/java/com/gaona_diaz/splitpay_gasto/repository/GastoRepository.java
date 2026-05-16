package com.gaona_diaz.splitpay_gasto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaona_diaz.splitpay_gasto.model.Gasto;

import java.util.List;

public interface GastoRepository extends JpaRepository<Gasto, String> {

    List<Gasto> findByEventoId(String eventoId);
}