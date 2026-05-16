package GruposRepository;



import org.springframework.data.jpa.repository.JpaRepository;

import model.ParticipanteEvento;

import java.util.List;

public interface ParticipanteRepository extends JpaRepository<ParticipanteEvento, String> {

    List<ParticipanteEvento> findByEventoId(String eventoId);
}