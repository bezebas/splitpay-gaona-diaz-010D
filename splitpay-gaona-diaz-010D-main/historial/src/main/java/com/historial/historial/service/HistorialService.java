package com.historial.historial.service;

import com.historial.historial.model.Historial;
import com.historial.historial.repository.HistorialRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // <-- Obligatorio: Le dice a Spring que esta es la capa de negocio
public class HistorialService {

    // Conexión con la capa de datos (Repository)
    private final HistorialRepository repository;

    // Constructor para la Inyección de Dependencias (Exigido como buena práctica)
    public HistorialService(HistorialRepository repository) {
        this.repository = repository;
    }

    // 1. Método para registrar una acción (POST)
    public Historial registrar(Historial historial) {
        return repository.save(historial);
    }

    // 2. Método para buscar todo el historial de un usuario (GET)
    public List<Historial> buscarPorUsuario(String usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    // 3. Método para buscar una acción específica por su ID (GET por ID)
    public Historial buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado con el ID: " + id));
    }
}