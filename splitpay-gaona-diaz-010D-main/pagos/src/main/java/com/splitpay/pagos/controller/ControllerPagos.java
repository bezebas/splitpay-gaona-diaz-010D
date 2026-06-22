package com.splitpay.pagos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.splitpay.pagos.model.Pagos;
import com.splitpay.pagos.services.ServicesPagos;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class ControllerPagos {
    private final ServicesPagos service;
    public ControllerPagos(ServicesPagos s) { this.service = s; }

    @PostMapping
    public ResponseEntity<Pagos> registrar(@RequestBody Pagos p) { return ResponseEntity.ok(service.registrarPago(p)); }

    @GetMapping("/evento/{eid}")
    public ResponseEntity<List<Pagos>> verPorEvento(@PathVariable String eid) { return ResponseEntity.ok(service.obtenerPorEvento(eid)); }
}
