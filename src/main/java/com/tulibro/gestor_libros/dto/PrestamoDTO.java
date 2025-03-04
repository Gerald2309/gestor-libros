package com.tulibro.gestor_libros.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class PrestamoDTO {

    private Long id;

    @NotNull(message = "Debe haber un cliente en el préstamo")
    private Long clienteId; // Solo almacenamos el ID del cliente

    @NotNull(message = "Debe haber un libro en el préstamo")
    private Long libroId; // Solo almacenamos el ID del libro

    @NotNull(message = "La fecha de préstamo no puede estar vacía")
    @PastOrPresent(message = "La fecha de préstamo no puede ser futura")
    private LocalDate fechaPrestamo;

    private LocalDate fechaDevolucion; // Puede ser NULL si el libro aún no se devolvió

    public PrestamoDTO(Long id, Long clienteId, Long libroId, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.id = id;
        this.clienteId = clienteId;
        this.libroId = libroId;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
