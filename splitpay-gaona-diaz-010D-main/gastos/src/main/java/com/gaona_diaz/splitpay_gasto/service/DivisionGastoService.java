package com.gaona_diaz.splitpay_gasto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaona_diaz.splitpay_gasto.model.DivisionGasto;
import com.gaona_diaz.splitpay_gasto.repository.DivisionGastoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class DivisionGastoService {

    @Autowired
    private DivisionGastoRepository repository;

    public DivisionGasto guardar(DivisionGasto d) {
        d.setId(UUID.randomUUID().toString());
        return repository.save(d);
    }

    public List<DivisionGasto> porGasto(String gastoId) {
        return repository.findByGastoId(gastoId);
    }
}