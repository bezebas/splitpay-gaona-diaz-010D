package com.reputacion.reputacion.repository;

import com.reputacion.reputacion.model.Reputacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// Hereda de JpaRepository para obtener todas las operaciones CRUD automáticas
public interface ReputacionRepository extends JpaRepository<Reputacion, String> {
    
    // Método personalizado para buscar la reputación directa de un usuario
    Optional<Reputacion> findByUsuarioId(String usuarioId);
}