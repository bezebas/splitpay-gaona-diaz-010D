package com.splitpay.reportes.controller;

import com.splitpay.reportes.model.Reportes;
import com.splitpay.reportes.service.ReportesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReportesController {
    private final ReportesService service;
    public ReportesController(ReportesService s) { this.service = s; }

    @PostMapping
    public ResponseEntity<Reportes> crear(@RequestBody Reportes r) { return ResponseEntity.ok(service.guardarReporte(r)); }

    @GetMapping("/usuario/{uid}/grupo/{gid}")
    public ResponseEntity<List<Reportes>> buscar(@PathVariable String uid, @PathVariable String gid) { 
        return ResponseEntity.ok(service.obtenerMensuales(uid, gid)); 
    }
}