package com.tulibro.gestor_libros.dto;

public class LibroDTO {

    private Long id;
    private String titulo;
    private AutorDTO autor; // Solo incluimos datos básicos del autor

    public LibroDTO(Long id, String titulo, AutorDTO autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public LibroDTO(Long id, String titulo) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public AutorDTO getAutor() {
        return autor;
    }

    public void setAutor(AutorDTO autor) {
        this.autor = autor;
    }
}
