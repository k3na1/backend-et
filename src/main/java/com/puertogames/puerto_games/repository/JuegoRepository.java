package com.puertogames.puerto_games.repository;

import com.puertogames.puerto_games.model.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuegoRepository extends JpaRepository<Juego, Long> {
    // JPARepository ya incluye los métodos necesarios
}
