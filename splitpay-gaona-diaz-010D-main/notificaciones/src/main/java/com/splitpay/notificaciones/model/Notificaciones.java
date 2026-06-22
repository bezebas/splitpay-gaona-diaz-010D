package com.splitpay.notificaciones.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "notificaciones")
public class Notificaciones {

    @Id
    private String id;

    @Column(name = "usuario_id", nullable = false)
    private String usuarioId;

    private String tipo;
    private String mensaje;
    private Boolean leida = false;
    private String prioridad;

    @Column(name = "creado_en", insertable = false, updatable = false)
    private LocalDateTime creadoEn;

    @PrePersist
    public void ensureId() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }
}