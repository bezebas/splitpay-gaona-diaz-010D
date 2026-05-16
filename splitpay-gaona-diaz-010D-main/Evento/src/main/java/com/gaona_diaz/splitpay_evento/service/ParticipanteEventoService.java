package com.gaona_diaz.splitpay_evento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaona_diaz.splitpay_evento.model.ParticipanteEvento;
import com.gaona_diaz.splitpay_evento.repository.ParticipanteEventoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipanteEventoService {

    @Autowired
    private ParticipanteEventoRepository repository;

    public ParticipanteEvento guardar(ParticipanteEvento p) {
        p.setId(UUID.randomUUID().toString());
        return repository.save(p);
    }

    public List<ParticipanteEvento> listarPorEvento(String eventoId) {
        return repository.findByEventoId(eventoId);
    }
}