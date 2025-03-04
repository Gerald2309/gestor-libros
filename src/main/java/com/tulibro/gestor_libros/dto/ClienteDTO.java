package com.tulibro.gestor_libros.dto;

import com.tulibro.gestor_libros.model.Cliente;
import com.tulibro.gestor_libros.model.Prestamo;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {
    private Long id;
    private String nombre;
    private String email;
    private List<Long> prestamosIds; // Solo incluir IDs para evitar bucles

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nombre = cliente.getNombre();
        this.email = cliente.getEmail();
        this.prestamosIds = cliente.getPrestamos().stream()
                .map(Prestamo::getId)
                .collect(Collectors.toList());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getPrestamosIds() {
        return prestamosIds;
    }

    public void setPrestamosIds(List<Long> prestamosIds) {
        this.prestamosIds = prestamosIds;
    }
}
