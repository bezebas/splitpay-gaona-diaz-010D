package com.splitpay.reportes.service;

import com.splitpay.reportes.model.Reportes;
import com.splitpay.reportes.repository.ReportesRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReportesService {
    private final ReportesRepository repo;
    public ReportesService(ReportesRepository r) { this.repo = r; }
    public Reportes guardarReporte(Reportes r) { return repo.save(r); }
    public List<Reportes> obtenerMensuales(String uid, String gid) { return repo.findByUsuarioIdAndGrupoId(uid, gid); }
}
