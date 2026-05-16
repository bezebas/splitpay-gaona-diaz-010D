package com.gaona_diaz.splitpay_evento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaona_diaz.splitpay_evento.model.Evento;
import com.gaona_diaz.splitpay_evento.repository.EventoRepository;
import com.gaona_diaz.splitpay_evento.client.GrupoClient;

import feign.FeignException;

import java.util.List;
import java.util.UUID;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private GrupoClient grupoClient;

    public Evento guardar(Evento evento) {

        try {
            // 🔥 validar que el grupo exista
            grupoClient.obtenerGrupo(evento.getGrupoId());

        } catch (FeignException.NotFound e) {

            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "El grupo no existe"
            );

        } catch (FeignException e) {

            throw new ResponseStatusException(
                HttpStatus.SERVICE_UNAVAILABLE,
                "Error al comunicarse con el servicio de grupo"
            );
        }

        evento.setId(UUID.randomUUID().toString());
        return eventoRepository.save(evento);
    }

    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    public Evento obtenerPorId(String id) {
        return eventoRepository.findById(id).orElse(null);
    }

    public List<Evento> porGrupo(String grupoId) {
        return eventoRepository.findByGrupoId(grupoId);
    }

    public void eliminar(String id) {
        eventoRepository.deleteById(id);
    }
}