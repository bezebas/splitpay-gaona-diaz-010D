package com.historial.historial.model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "historial")
public class Historial {

    @Id
    @Column(length = 50)
    private String id;

    @Column(name = "usuario_id", nullable = false, length = 50)
    private String usuarioId;

    @Column(name = "grupo_id", length = 50)
    private String grupoId;

    @Column(name = "evento_id", length = 50)
    private String eventoId;

    @Column(length = 100)
    private String accion;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha_accion", insertable = false, updatable = false)
    private LocalDateTime fechaAccion;

    @PrePersist
    public void asegurarId() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }
}
