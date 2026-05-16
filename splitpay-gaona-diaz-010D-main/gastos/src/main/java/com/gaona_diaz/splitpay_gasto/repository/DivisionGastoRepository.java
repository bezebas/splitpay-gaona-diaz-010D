package com.gaona_diaz.splitpay_gasto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaona_diaz.splitpay_gasto.model.DivisionGasto;

import java.util.List;

public interface DivisionGastoRepository extends JpaRepository<DivisionGasto, String> {

    List<DivisionGasto> findByGastoId(String gastoId);
}
