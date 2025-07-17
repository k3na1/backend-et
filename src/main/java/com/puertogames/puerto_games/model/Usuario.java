package com.puertogames.puerto_games.model;

import jakarta.persistence.*;
import lombok.*;
//DTO Data Transfer Object= Objeto de transferencia de datos: para simular la respuesta de MS
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String correo;
    private String rol;
}