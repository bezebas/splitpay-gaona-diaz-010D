package com.splitpay.pagos.services;

import org.springframework.stereotype.Service;

import com.splitpay.pagos.model.Pagos;
import com.splitpay.pagos.repository.RepositoryPagos;

import java.util.List;

@Service
public class ServicesPagos {
    private final RepositoryPagos repo;
    public ServicesPagos(RepositoryPagos repo) { this.repo = repo; }
    public Pagos registrarPago(Pagos p) { return repo.save(p); }
    public List<Pagos> obtenerPorEvento(String eid) { return repo.findByEventoId(eid); }
}