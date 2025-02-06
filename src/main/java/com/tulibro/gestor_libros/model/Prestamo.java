package com.tulibro.gestor_libros.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @NotNull(message = "Debe haber un cliente en el préstamo")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    @NotNull(message = "Debe haber un libro en el préstamo")
    private Libro libro;

    @NotNull(message = "La fecha de préstamo no puede estar vacía")
    @PastOrPresent(message = "La fecha de préstamo no puede ser futura")
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion; // NULL si el libro aún no se devolvió

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
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
