package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import service.ParticipanteService;

import java.util.List;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService service; 

    @PostMapping
    public ParticipanteService guardar(@RequestBody ParticipanteService p) {
        return service.guardar(p);
    }

    @GetMapping("/evento/{eventoId}")
    public List<ParticipanteService> listar(@PathVariable String eventoId) {
        return service.listarPorEvento(eventoId);
    }
}