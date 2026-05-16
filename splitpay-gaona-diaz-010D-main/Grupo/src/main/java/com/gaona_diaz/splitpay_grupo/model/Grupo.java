package com.gaona_diaz.splitpay_grupo.model;



import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grupos")

public class Grupo {



  @Id

  private String id = UUID.randomUUID().toString();
  private String nombre;
  private String descripcion;
  private String creadoPor;
  private LocalDateTime creadoEn = LocalDateTime.now();
  private Boolean activo = true;

}
