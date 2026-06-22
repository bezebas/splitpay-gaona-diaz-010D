package com.splitpay.notificaciones.services;

import com.splitpay.notificaciones.model.Notificaciones;
import com.splitpay.notificaciones.repository.RepositoryNotificaciones;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesNotificaciones {

    private final RepositoryNotificaciones repository;

    public ServicesNotificaciones(RepositoryNotificaciones repository) {
        this.repository = repository;
    }

    public Notificaciones guardar(Notificaciones n) {
        return repository.save(n);
    }

    public List<Notificaciones> listarPorUsuario(String uid) {
        return repository.findByUsuarioIdOrderByCreadoEnDesc(uid);
    }

    public Notificaciones marcarLeida(String id) {
        Notificaciones n = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrada"));

        n.setLeida(true);

        return repository.save(n);
    }
}