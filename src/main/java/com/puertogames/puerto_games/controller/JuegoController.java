package com.puertogames.puerto_games.controller;

import com.puertogames.puerto_games.model.Juego;
import com.puertogames.puerto_games.repository.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/juegos")
@CrossOrigin("https://vercel.com/k3na1s-projects/frontend-et/61kcyPTt7M4app2qH5Zao3upE8yq")
public class JuegoController {

    @Autowired
    private JuegoRepository juegoRepo;


    //Agregar juego
    @PostMapping
    public Juego agregarJuego(@RequestBody Juego juego) {
        return juegoRepo.save(juego);
    }

    //Obtener todos los juegos
    @GetMapping
    public List<Juego> obtenerTodos() {
        return juegoRepo.findAll();
    }

    //Borrar juego por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarJuego(@PathVariable Long id) {
        if (juegoRepo.existsById(id)) {
            juegoRepo.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Juego> actualizarJuego(@PathVariable Long id, @RequestBody Map<String, Object> cambios) {
        return juegoRepo.findById(id).map(juego -> {
            if (cambios.containsKey("nombre")) {
                juego.setNombre((String) cambios.get("nombre"));
            }
            if (cambios.containsKey("genero")) {
                juego.setGenero((String) cambios.get("genero"));
            }
            if (cambios.containsKey("plataforma")) {
                juego.setPlataforma((String) cambios.get("plataforma"));
            }
            if (cambios.containsKey("descripcion")) {
                juego.setDescripcion((String) cambios.get("descripcion"));
            }
            if (cambios.containsKey("precio")) {
                juego.setPrecio((String) cambios.get("precio"));
            }
            if (cambios.containsKey("imagen")) {
                juego.setImagen((String) cambios.get("imagen"));
            }
            juegoRepo.save(juego);
            return ResponseEntity.ok(juego);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
