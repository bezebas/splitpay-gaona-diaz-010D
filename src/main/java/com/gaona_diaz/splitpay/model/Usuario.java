package com.gaona_diaz.splitpay.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
