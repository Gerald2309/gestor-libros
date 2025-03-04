package com.tulibro.gestor_libros.controller;

import com.tulibro.gestor_libros.dto.PrestamoDTO;
import com.tulibro.gestor_libros.service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public ResponseEntity<List<PrestamoDTO>> obtenerTodosLosPrestamos() {
        List<PrestamoDTO> prestamos = prestamoService.obtenerTodosLosPrestamos();
        return ResponseEntity.ok(prestamos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestamoDTO> obtenerPrestamoPorId(@PathVariable Long id) {
        return prestamoService.obtenerPrestamoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PrestamoDTO> guardarPrestamo(@Valid @RequestBody PrestamoDTO prestamoDTO) {
        PrestamoDTO nuevoPrestamo = prestamoService.guardarPrestamo(prestamoDTO);
        return ResponseEntity.ok(nuevoPrestamo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrestamo(@PathVariable Long id) {
        prestamoService.eliminarPrestamo(id);
        return ResponseEntity.noContent().build();
    }
}

