package com.tulibro.gestor_libros.service;

import com.tulibro.gestor_libros.dto.PrestamoDTO;
import com.tulibro.gestor_libros.model.Prestamo;
import com.tulibro.gestor_libros.model.Cliente;
import com.tulibro.gestor_libros.model.Libro;
import com.tulibro.gestor_libros.repository.PrestamoRepository;
import com.tulibro.gestor_libros.repository.ClienteRepository;
import com.tulibro.gestor_libros.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private LibroRepository libroRepository;

    public List<PrestamoDTO> obtenerTodosLosPrestamos() {
        List<Prestamo> prestamos = prestamoRepository.findAll();
        return prestamos.stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public Optional<PrestamoDTO> obtenerPrestamoPorId(Long id) {
        return prestamoRepository.findById(id).map(this::convertirADTO);
    }

    private Cliente obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }

    private Libro obtenerLibroPorId(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con ID: " + id));
    }


    public PrestamoDTO guardarPrestamo(PrestamoDTO prestamoDTO) {
        // Primero, obtén las entidades Cliente y Libro a partir de los ID
        Cliente cliente = obtenerClientePorId(prestamoDTO.getClienteId());
        Libro libro = obtenerLibroPorId(prestamoDTO.getLibroId());

        // Luego, conviértelo en una entidad Prestamo
        Prestamo prestamo = convertirAEntidad(prestamoDTO, cliente, libro);

        // Guarda el préstamo en la base de datos
        Prestamo prestamoGuardado = prestamoRepository.save(prestamo);

        // Convierte la entidad Prestamo guardada a un DTO y lo retorna
        return convertirADTO(prestamoGuardado);
    }



    public void eliminarPrestamo(Long id) {
        prestamoRepository.deleteById(id);
    }

    private PrestamoDTO convertirADTO(Prestamo prestamo) {
        return new PrestamoDTO(
                prestamo.getId(),
                prestamo.getCliente().getId(),
                prestamo.getLibro().getId(),
                prestamo.getFechaPrestamo(),
                prestamo.getFechaDevolucion()
        );
    }

    private Prestamo convertirAEntidad(PrestamoDTO dto, Cliente cliente, Libro libro) {
        Prestamo prestamo = new Prestamo();
        prestamo.setCliente(cliente);
        prestamo.setLibro(libro);
        prestamo.setFechaPrestamo(dto.getFechaPrestamo());
        prestamo.setFechaDevolucion(dto.getFechaDevolucion());
        return prestamo;
    }
}
