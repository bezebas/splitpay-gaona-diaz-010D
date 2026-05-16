package com.gaona_diaz.splitpay_usuario.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Table(name= "usuarios")
@Data
@Entity
public class Usuario 
{
    @Id
    private String id;
    private String nombre;
    private String correo;
    private String contrasenaHash;
    private float puntajeReputacion;
    private LocalDateTime creado_en = LocalDateTime.now();
    private boolean activo = true;
}
