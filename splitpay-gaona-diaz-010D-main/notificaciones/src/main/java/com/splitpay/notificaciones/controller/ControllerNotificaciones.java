package com.splitpay.notificaciones.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.splitpay.notificaciones.model.Notificaciones;
import com.splitpay.notificaciones.services.ServicesNotificaciones;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class ControllerNotificaciones {

    private final ServicesNotificaciones service;

    public ControllerNotificaciones(ServicesNotificaciones s) {
        this.service = s;
    }

    @PostMapping
    public ResponseEntity<Notificaciones> crear(@RequestBody Notificaciones n) {
        return ResponseEntity.ok(service.guardar(n));
    }

    @GetMapping("/usuario/{uid}")
    public ResponseEntity<List<Notificaciones>> listar(@PathVariable String uid) {
        return ResponseEntity.ok(service.listarPorUsuario(uid));
    }

    @PutMapping("/{id}/leer")
    public ResponseEntity<Notificaciones> leer(@PathVariable String id) {
        return ResponseEntity.ok(service.marcarLeida(id));
    }
}
