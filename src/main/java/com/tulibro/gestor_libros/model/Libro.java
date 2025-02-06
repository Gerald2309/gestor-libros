package com.tulibro.gestor_libros.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El título no puede estar vacío")
    @Size(min = 2, max = 150, message = "El título debe tener entre 2 y 150 caracteres")
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    @NotNull(message = "El libro debe tener un autor")
    private Autor autor;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL)
    private List<Prestamo> prestamos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
}
