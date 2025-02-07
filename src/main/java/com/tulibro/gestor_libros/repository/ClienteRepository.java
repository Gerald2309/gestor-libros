package com.tulibro.gestor_libros.repository;

import com.tulibro.gestor_libros.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {
}
