package com.grupo.gastos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo.gastos.model.DivisionGasto;
import com.grupo.gastos.repository.DivisionRepository;

import java.util.List;
import java.util.UUID;

@Service
public class DivisionService {

    @Autowired
    private DivisionRepository repository;

    public DivisionGasto guardar(DivisionGasto d) {
        d.setId(UUID.randomUUID().toString());
        return repository.save(d);
    }

    public List<DivisionGasto> porGasto(String gastoId) {
        return repository.findByGastoId(gastoId);
    }
}