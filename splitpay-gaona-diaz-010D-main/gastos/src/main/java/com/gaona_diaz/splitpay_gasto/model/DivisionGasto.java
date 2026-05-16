package com.gaona_diaz.splitpay_gasto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "divisiones_gasto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DivisionGasto {

    @Id
    private String id;
    private String gastoId;
    private String usuarioId;
    private Float montoAdeudado;
}