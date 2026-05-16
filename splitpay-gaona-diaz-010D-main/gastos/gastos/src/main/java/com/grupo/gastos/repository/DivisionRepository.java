package com.grupo.gastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grupo.gastos.model.DivisionGasto;

import java.util.List;

public interface DivisionRepository extends JpaRepository<DivisionGasto, String> {

    List<DivisionGasto> findByGastoId(String gastoId);
}