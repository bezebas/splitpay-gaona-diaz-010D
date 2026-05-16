package com.gaona_diaz.splitpay_evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaona_diaz.splitpay_evento.model.Evento;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, String> {

    List<Evento> findByGrupoId(String grupoId);
}
