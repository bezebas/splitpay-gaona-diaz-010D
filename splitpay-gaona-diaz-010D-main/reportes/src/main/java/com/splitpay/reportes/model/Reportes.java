package com.splitpay.reportes.model;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "reportes")
public class Reportes {
    @Id
    private String id;
    @Column(name = "usuario_id") private String usuarioId;
    @Column(name = "grupo_id") private String grupoId;
    @Column(name = "total_gastado") private BigDecimal totalGastado;
    @Column(name = "total_pagado") private BigDecimal totalPagado;
    @Column(name = "total_adeudado") private BigDecimal totalAdeudado;
    private Integer mes;
    private Integer anio;
    @Column(name = "generado_en", insertable = false, updatable = false) private LocalDateTime generadoEn;

    @PrePersist public void init() { this.id = UUID.randomUUID().toString(); }
}