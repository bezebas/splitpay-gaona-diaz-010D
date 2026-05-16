package com.gaona_diaz.splitpay_evento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gaona_diaz.splitpay_evento.model.ParticipanteEvento;
import com.gaona_diaz.splitpay_evento.service.ParticipanteEventoService;

import java.util.List;

@RestController
@RequestMapping("/participantes")
public class ParticipanteEventoController {

    @Autowired
    private ParticipanteEventoService service; 

    @PostMapping
    public ParticipanteEvento guardar(@RequestBody ParticipanteEvento p) {
        return service.guardar(p);
    }

    @GetMapping("/evento/{eventoId}")
    public List<ParticipanteEvento> listar(@PathVariable String eventoId) {
        return service.listarPorEvento(eventoId);
    }
}