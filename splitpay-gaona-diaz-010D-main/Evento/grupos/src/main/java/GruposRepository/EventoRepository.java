package GruposRepository;


import org.springframework.data.jpa.repository.JpaRepository;

import model.Eventos;

import java.util.List;

public interface EventoRepository extends JpaRepository<Eventos, String> {

    List<Eventos> findByGrupoId(String grupoId);
}