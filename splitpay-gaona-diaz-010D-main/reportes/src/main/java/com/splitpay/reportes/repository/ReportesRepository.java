package com.splitpay.reportes.repository;

import com.splitpay.reportes.model.Reportes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReportesRepository extends JpaRepository<Reportes, String> {
    List<Reportes> findByUsuarioIdAndGrupoId(String usuarioId, String grupoId);
}