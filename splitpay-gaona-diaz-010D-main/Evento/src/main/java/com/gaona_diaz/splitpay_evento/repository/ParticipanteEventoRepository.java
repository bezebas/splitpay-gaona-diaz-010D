package com.gaona_diaz.splitpay_evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaona_diaz.splitpay_evento.model.ParticipanteEvento;

import java.util.List;

public interface ParticipanteEventoRepository extends JpaRepository<ParticipanteEvento, String> {

    List<ParticipanteEvento> findByEventoId(String eventoId);
}
