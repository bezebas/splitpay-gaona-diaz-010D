package com.gaona_diaz.splitpay_grupo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gaona_diaz.splitpay_grupo.model.MiembroGrupo;
import com.gaona_diaz.splitpay_grupo.service.MiembroGrupoService;

@RestController

@RequestMapping("/miembros")

public class MiembroGrupoController {
    @Autowired
    private MiembroGrupoService miembroGrupoService;

    @GetMapping
    public List<MiembroGrupo> listarMiembros() {
        return miembroGrupoService.listarMiembros();
    }

    @PostMapping
    public MiembroGrupo guardarMiembro(@RequestBody MiembroGrupo miembroGrupo) {
        return miembroGrupoService.guardarMiembro(miembroGrupo);
    }

    @GetMapping("/grupo/{grupoId}")
    public List<MiembroGrupo> obtenerMiembrosPorGrupo(@PathVariable String grupoId) {
        return miembroGrupoService.obtenerMiembrosPorGrupo(grupoId);

    }

    @GetMapping("/usuario/{usuarioId}")
    public List<MiembroGrupo> obtenerGruposPorUsuario(@PathVariable String usuarioId) {
        return miembroGrupoService.obtenerGruposPorUsuario(usuarioId);

    }

    @DeleteMapping("/{id}")
    public void eliminarMiembro(@PathVariable String id) {
        miembroGrupoService.eliminarMiembro(id);
    }
}
