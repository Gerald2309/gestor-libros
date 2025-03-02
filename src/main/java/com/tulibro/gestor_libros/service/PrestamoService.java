package com.tulibro.gestor_libros.service;

import com.tulibro.gestor_libros.model.Prestamo;
import com.tulibro.gestor_libros.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Prestamo> obtenerTodosLosPrestamos() {
        return prestamoRepository.findAll();
    }

    public Optional<Prestamo> obtenerPrestamoPorId(Long id) {
        return prestamoRepository.findById(id);
    }

    public Prestamo registrarPrestamo(Prestamo prestamo) {
        // Lógica de negocio: verificar que el cliente no tenga más de 3 libros prestados



        long librosPrestados =  prestamo.getCliente().getId();

        if (librosPrestados >= 3) {
            throw new IllegalStateException("El cliente ya tiene 3 libros prestados. No puede solicitar más.");
        }

        return prestamoRepository.save(prestamo);
    }

    public void eliminarPrestamo(Long id) {
        prestamoRepository.deleteById(id);
    }

}
