package com.gaona_diaz.splitpay_evento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gaona_diaz.splitpay_evento.model.Evento;
import com.gaona_diaz.splitpay_evento.service.EventoService;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @PostMapping
    public Evento guardar(@RequestBody Evento evento) {
        return service.guardar(evento);
    }

    @GetMapping
    public List<Evento> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Evento obtener(@PathVariable String id) {
        return service.obtenerPorId(id);
    }

    @GetMapping("/grupo/{grupoId}")
    public List<Evento> porGrupo(@PathVariable String grupoId) {
        return service.porGrupo(grupoId);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.eliminar(id);
    }
}