package com.tulibro.gestor_libros.repository;

import com.tulibro.gestor_libros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long>{



}
