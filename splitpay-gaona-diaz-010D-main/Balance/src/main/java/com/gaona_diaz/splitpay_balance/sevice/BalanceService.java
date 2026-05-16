package com.gaona_diaz.splitpay_balance.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gaona_diaz.splitpay_balance.model.Balance;
import com.gaona_diaz.splitpay_balance.repository.BalanceRepository;
import com.gaona_diaz.splitpay_balance.client.UsuarioClient;

import feign.FeignException;

import java.util.List;
import java.util.UUID;

@Service
public class BalanceService {

    @Autowired
    private BalanceRepository repository;

    @Autowired
    private UsuarioClient usuarioClient;

    public Balance guardar(Balance b) {

        try {
            usuarioClient.obtenerUsuario(b.getUsuarioDeudorId());

            usuarioClient.obtenerUsuario(b.getUsuarioAcreedorId());

        } catch (FeignException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no existe");

        } catch (FeignException e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Error con usuario-service");
        }

        b.setId(UUID.randomUUID().toString());
        b.setEstado("PENDIENTE");

        return repository.save(b);
    }

    public List<Balance> porEvento(String eventoId) {
        return repository.findByEventoId(eventoId);
    }

    public Balance marcarPagado(String id) {

        Balance b = repository.findById(id).orElse(null);

        if (b == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Balance no encontrado");
        }

        b.setEstado("SALDADO");
        return repository.save(b);
    }
}