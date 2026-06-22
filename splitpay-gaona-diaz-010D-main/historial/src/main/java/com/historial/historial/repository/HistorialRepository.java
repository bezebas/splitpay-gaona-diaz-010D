package com.historial.historial.repository;

import com.historial.historial.model.Historial; // <-- Importación actualizada
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface HistorialRepository extends JpaRepository<Historial, String> {
    List<Historial> findByUsuarioId(String usuarioId);
}