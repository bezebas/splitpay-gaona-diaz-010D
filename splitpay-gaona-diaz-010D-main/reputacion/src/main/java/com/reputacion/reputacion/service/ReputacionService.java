package com.reputacion.reputacion.service;

import com.reputacion.reputacion.model.Reputacion;
import com.reputacion.reputacion.repository.ReputacionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReputacionService {

    private final ReputacionRepository repository;

    // Inyección por constructor del repositorio
    public ReputacionService(ReputacionRepository repository) {
        this.repository = repository;
    }

    // Guardar o inicializar la reputación de un usuario
    public Reputacion crear(Reputacion reputacion) {
        return repository.save(reputacion);
    }

    // Listar todas las reputaciones registradas
    public List<Reputacion> listarTodo() {
        return repository.findAll();
    }

    // Buscar reputación por su ID único
    public Reputacion buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reputación no encontrada con ID: " + id));
    }

    // Buscar reputación directamente por el ID del Usuario
    public Reputacion buscarPorUsuario(String usuarioId) {
        return repository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new RuntimeException("No hay historial de reputación para el usuario: " + usuarioId));
    }

    // Modificar puntaje y nivel (Requerimiento PUT)
    public Reputacion actualizar(String id, Reputacion datosNuevos) {
        Reputacion existente = buscarPorId(id);
        existente.setPuntaje(datosNuevos.getPuntaje());
        existente.setNivel(datosNuevos.getNivel());
        existente.setObservaciones(datosNuevos.getObservaciones());
        return repository.save(existente);
    }

    // Eliminar registro de reputación (Requerimiento DELETE)
    public void eliminar(String id) {
        Reputacion existente = buscarPorId(id);
        repository.delete(existente);
    }
}