package com.splitpay.pagos.model;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "pagos")
public class Pagos {
    @Id
    private String id;
    @Column(name = "deudor_id") private String deudorId;
    @Column(name = "acreedor_id") private String acreedorId;
    @Column(name = "evento_id") private String eventoId;
    private BigDecimal monto;
    @Column(name = "metodo_pago") private String metodoPago;
    private String estado;
    @Column(name = "fecha_pago", insertable = false, updatable = false) private LocalDateTime fechaPago;

    @PrePersist public void init() { this.id = UUID.randomUUID().toString(); }
}