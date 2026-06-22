package com.reputacion.reputacion.controller;

import com.reputacion.reputacion.model.Reputacion;
import com.reputacion.reputacion.service.ReputacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reputacion")
public class ReputacionController {

    private final ReputacionService service;

    public ReputacionController(ReputacionService service) {
        this.service = service;
    }

    // POST: Inicializar reputación (Retorna 201 Created)
    @PostMapping
    public ResponseEntity<Reputacion> crear(@RequestBody Reputacion reputacion) {
        return new ResponseEntity<>(service.crear(reputacion), HttpStatus.CREATED);
    }

    // GET: Listar todas
    @GetMapping ("/listar")
    public ResponseEntity<List<Reputacion>> listarTodo() {
        return ResponseEntity.ok(service.listarTodo());
    }

    // GET por ID de registro
    @GetMapping("/{id}")
    public ResponseEntity<Reputacion> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // GET por ID de Usuario específico
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<Reputacion> buscarPorUsuario(@PathVariable String usuarioId) {
        return ResponseEntity.ok(service.buscarPorUsuario(usuarioId));
    }

    // PUT: Actualizar puntaje/nivel por ID
    @PutMapping("/{id}")
    public ResponseEntity<Reputacion> actualizar(@PathVariable String id, @RequestBody Reputacion reputacion) {
        return ResponseEntity.ok(service.actualizar(id, reputacion));
    }

    // DELETE: Eliminar reputación por ID (Retorna 204 No Content)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}