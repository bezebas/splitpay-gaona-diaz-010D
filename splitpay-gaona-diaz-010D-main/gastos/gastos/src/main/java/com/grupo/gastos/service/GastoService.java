package com.grupo.gastos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo.gastos.model.Gasto;
import com.grupo.gastos.repository.GastoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class GastoService {

    @Autowired
    private GastoRepository repository;

    public Gasto guardar(Gasto gasto) {
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