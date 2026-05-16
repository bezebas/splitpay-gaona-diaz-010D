package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import GruposRepository.ParticipanteRepository;
import model.ParticipanteEvento;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository repository;

    public ParticipanteEvento guardar(ParticipanteEvento p) {
        p.setId(UUID.randomUUID().toString());
        return repository.save(p);
    }

    public List<ParticipanteEvento> listarPorEvento(String eventoId) {
        return repository.findByEventoId(eventoId);
    }
}