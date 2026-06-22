package com.historial.historial.controller;

import com.historial.historial.model.Historial; // <-- Importación actualizada
import com.historial.historial.service.HistorialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/historial")
public class HistorialController {

    private final HistorialService service;

    public HistorialController(HistorialService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Historial> crear(@RequestBody Historial historial) {
        Historial guardado = service.registrar(historial);
        return new ResponseEntity<>(guardado, HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Historial>> listarPorUsuario(@PathVariable String usuarioId) {
        return ResponseEntity.ok(service.buscarPorUsuario(usuarioId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Historial> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}