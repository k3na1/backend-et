package com.puertogames.puerto_games.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String genero;
    private String plataforma;
    private String descripcion;
    private String precio;
    private String imagen;
}
