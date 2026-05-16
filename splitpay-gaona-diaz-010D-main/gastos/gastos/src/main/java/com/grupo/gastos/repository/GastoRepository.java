package com.grupo.gastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grupo.gastos.model.Gasto;

import java.util.List;

public interface GastoRepository extends JpaRepository<Gasto, String> {

    List<Gasto> findByEventoId(String eventoId);
}