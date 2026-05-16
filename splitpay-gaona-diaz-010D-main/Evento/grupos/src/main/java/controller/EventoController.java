package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Eventos;
import service.EventoService;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Eventos> listar() {
        return eventoService.listarEventos();
    }

    @PostMapping
    public Eventos guardar(@RequestBody Eventos evento) {
        return eventoService.guardarEvento(evento);
    }

    @GetMapping("/{id}")
    public Eventos obtener(@PathVariable String id) {
        return eventoService.obtenerEventoPorId(id);
    }

    @GetMapping("/grupo/{grupoId}")
    public List<Eventos> porGrupo(@PathVariable String grupoId) {
        return eventoService.obtenerEventosPorGrupo(grupoId);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        eventoService.eliminarEvento(id);
    }
}
