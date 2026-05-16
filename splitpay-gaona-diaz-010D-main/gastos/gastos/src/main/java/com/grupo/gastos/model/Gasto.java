package com.grupo.gastos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gastos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gasto {

    @Id
    private String id;
    private String eventoId;
    private String pagadoPor;
    private String descripcion;
    private String categoria;
    private Float montoTotal;
    private String tipoDivision; // EQUITATIVO o PERSONALIZADO
}
