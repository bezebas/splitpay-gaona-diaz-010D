package com.splitpay.notificaciones.repository;

import com.splitpay.notificaciones.model.Notificaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RepositoryNotificaciones extends JpaRepository<Notificaciones, String> {

    List<Notificaciones> findByUsuarioIdOrderByCreadoEnDesc(String usuarioId);

}