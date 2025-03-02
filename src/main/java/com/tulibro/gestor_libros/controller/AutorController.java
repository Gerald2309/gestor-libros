package com.tulibro.gestor_libros.controller;

import com.tulibro.gestor_libros.model.Autor;
import com.tulibro.gestor_libros.model.Libro;
import com.tulibro.gestor_libros.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;


    @GetMapping
    public ResponseEntity<List<Autor>> obtenerTodosLosAutores() {
        List<Autor> autores = autorService.obtenerTodosLosAutores();
        return ResponseEntity.ok(autores);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerAutorPorId(@PathVariable Long id) {
        Optional<Autor> autor = autorService.obtenerAutorPorId(id);
        return autor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Autor> guardarAutor(@RequestBody Autor autor) {
        return ResponseEntity.ok(autorService.guardarAutor(autor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAutor(@PathVariable Long id) {
        autorService.eliminarAutor(id);
        return ResponseEntity.noContent().build();
    }


}
