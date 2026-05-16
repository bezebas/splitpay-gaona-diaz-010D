package com.gaona_diaz.splitpay_gasto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaona_diaz.splitpay_gasto.model.Gasto;
import com.gaona_diaz.splitpay_gasto.repository.GastoRepository;
import com.gaona_diaz.splitpay_gasto.client.EventoClient;

import feign.FeignException;

import java.util.List;
import java.util.UUID;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class GastoService {

    @Autowired
    private GastoRepository repository;

    @Autowired
    private EventoClient eventoClient;

    public Gasto guardar(Gasto gasto) {

        try {
            // 🔥 Validar que el evento exista
            eventoClient.obtenerEvento(gasto.getEventoId());

        } catch (FeignException.NotFound e) {

            // ❌ Evento no existe → 404 real
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El evento no existe");

        } catch (FeignException e) {

            // ❌ Error de comunicación → 503
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,
                    "Error al comunicarse con el servicio de eventos");
        }

        // ✅ Si pasa la validación, se guarda
        gasto.setId(UUID.randomUUID().toString());

        return repository.save(gasto);
    }

    public List<Gasto> listar() {
        return repository.findAll();
    }

    public List<Gasto> porEvento(String eventoId) {
        return repository.findByEventoId(eventoId);
    }

    public void eliminar(String id) {
        repository.deleteById(id);
    }
}