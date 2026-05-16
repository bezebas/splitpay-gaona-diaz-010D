package service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GruposRepository.EventoRepository;
import model.Eventos;
import java.util.List;
import java.util.UUID;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Eventos> listarEventos() {
        return eventoRepository.findAll();
    }

    public Eventos guardarEvento(Eventos evento) {
        evento.setId(UUID.randomUUID().toString());
        return eventoRepository.save(evento);
    }

    public Eventos obtenerEventoPorId(String id) {
        return eventoRepository.findById(id).orElse(null);
    }

    public List<Eventos> obtenerEventosPorGrupo(String grupoId) {
        return eventoRepository.findByGrupoId(grupoId);
    }
    public void eliminarEvento(String id) {
        eventoRepository.deleteById(id);
    }
}
