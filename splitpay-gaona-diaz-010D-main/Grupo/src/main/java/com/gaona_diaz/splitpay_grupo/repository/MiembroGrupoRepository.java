package com.gaona_diaz.splitpay_grupo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaona_diaz.splitpay_grupo.model.MiembroGrupo;

@Repository
public interface MiembroGrupoRepository extends JpaRepository<MiembroGrupo, String> {
  List<MiembroGrupo> findByGrupoId(String grupoId);
  List<MiembroGrupo> findByUsuarioId(String usuarioId);

}
