package com.tulibro.gestor_libros.service;

import com.tulibro.gestor_libros.dto.AutorDTO;
import com.tulibro.gestor_libros.dto.LibroDTO;
import com.tulibro.gestor_libros.model.Autor;
import com.tulibro.gestor_libros.model.Libro;
import com.tulibro.gestor_libros.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<LibroDTO> obtenerTodosLosLibros() {
        List<Libro> libros = libroRepository.findAll();
        return libros.stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    private LibroDTO convertirADTO(Libro libro) {
        AutorDTO autorDTO = new AutorDTO(libro.getAutor().getId(), libro.getAutor().getNombre());
        return new LibroDTO(libro.getId(), libro.getTitulo(), autorDTO);
    }

    private Libro convertirAEntidad(LibroDTO libroDTO, Autor autor) {
        Libro libro = new Libro();
        libro.setTitulo(libroDTO.getTitulo());
        libro.setAutor(autor);
        return libro;
    }

//    public List<Libro> obtenerTodosLosLibros() {
//        return libroRepository.findAll();
//    }

    public Optional<Libro> obtenerLibroPorId(Long id) {
        return libroRepository.findById(id);
    }

    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }


}
