package com.tulibro.gestor_libros.repository;

import com.tulibro.gestor_libros.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository <Prestamo, Long> {


}
