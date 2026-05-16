package com.gaona_diaz.splitpay_balance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "balances")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Balance {

    @Id
    private String id;
    private String eventoId;
    private String usuarioDeudorId;
    private String usuarioAcreedorId;
    private float monto;
    private String estado; // PENDIENTE o SALDADO

}