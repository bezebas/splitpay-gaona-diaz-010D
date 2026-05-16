package com.gaona_diaz.splitpay_grupo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaona_diaz.splitpay_grupo.model.Grupo;
import com.gaona_diaz.splitpay_grupo.repository.GrupoRepository;

@Service
public class GrupoService {

  @Autowired
  private GrupoRepository grupoRepository;

  public List<Grupo> listarGrupos() {
    return grupoRepository.findAll();
  }

  public Grupo guardarGrupo(Grupo grupo) {

    // SOLO validación mínima real
    if (grupo.getNombre() == null || grupo.getNombre().isBlank()) {
      throw new RuntimeException("Nombre requerido");
    }

    // ID automático
    if (grupo.getId() == null || grupo.getId().isBlank()) {
      grupo.setId(UUID.randomUUID().toString());
    }

    return grupoRepository.save(grupo);
  }

  public Grupo obtenerGrupoPorId(String id) {
    return grupoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));
  }

  public void eliminarGrupo(String id) {

    if (!grupoRepository.existsById(id)) {
      throw new RuntimeException("El grupo no existe");
    }

    grupoRepository.deleteById(id);
  }
}