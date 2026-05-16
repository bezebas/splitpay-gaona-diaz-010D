package com.gaona_diaz.splitpay_grupo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gaona_diaz.splitpay_grupo.model.Grupo;
import com.gaona_diaz.splitpay_grupo.service.GrupoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

  @Autowired
  private GrupoService grupoService;

  // LISTAR TODOS
  @GetMapping
  public List<Grupo> listarGrupos() {
    return grupoService.listarGrupos();
  }

  // CREAR GRUPO (con validación + manejo de errores como gasto)
  @PostMapping
  public ResponseEntity<?> crear(@Valid @RequestBody Grupo grupo) {
    try {
      Grupo creado = grupoService.guardarGrupo(grupo);
      return ResponseEntity.ok(creado);
    } catch (RuntimeException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  // OBTENER POR ID
  @GetMapping("/{id}")
  public ResponseEntity<?> obtenerGrupoPorId(@PathVariable String id) {
    try {
      Grupo grupo = grupoService.obtenerGrupoPorId(id);
      return ResponseEntity.ok(grupo);
    } catch (RuntimeException e) {
      return ResponseEntity.status(404).body(e.getMessage());
    }
  }

  // ELIMINAR
  @DeleteMapping("/{id}")
  public ResponseEntity<?> eliminarGrupo(@PathVariable String id) {
    try {
      grupoService.eliminarGrupo(id);
      return ResponseEntity.ok("Grupo eliminado correctamente");
    } catch (RuntimeException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}