package com.reputacion.reputacion.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
@Table(name = "reputaciones")
public class Reputacion {

    @Id
    @Column(length = 50)
    private String id;

    // ID del usuario al que le pertenece esta reputación
    @Column(name = "usuario_id", nullable = false, unique = true, length = 50)
    private String usuarioId;

    // Puntaje numérico (ej: de 0 a 100)
    private int puntaje;

    // Categoría (ej: "EXCELENTE", "REGULAR", "MOROSO")
    @Column(length = 50)
    private String nivel;

    // Comentarios adicionales sobre el comportamiento del usuario
    @Column(columnDefinition = "TEXT")
    private String observaciones;

    // Generador automático de ID único antes de guardar en la BD
    @PrePersist
    public void asegurarId() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }
}
