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
@Table(name = "miembros_grupo")

public class MiembroGrupo {



  @Id
  private String id = UUID.randomUUID().toString();
  private String grupoId;
  private String usuarioId;
  private String rol;
  private LocalDateTime fechaUnion = LocalDateTime.now();

}
