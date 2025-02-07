package com.tulibro.gestor_libros.repository;

import com.tulibro.gestor_libros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
