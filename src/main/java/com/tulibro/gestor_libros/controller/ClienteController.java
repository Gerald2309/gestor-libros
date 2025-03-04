package com.tulibro.gestor_libros.controller;

import com.tulibro.gestor_libros.dto.ClienteDTO;
import com.tulibro.gestor_libros.model.Cliente;
import com.tulibro.gestor_libros.repository.ClienteRepository;
import com.tulibro.gestor_libros.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;

//    @GetMapping
//    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
//        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
//        return ResponseEntity.ok(clientes);
//    }
    @GetMapping
    public List<ClienteDTO> obtenerTodosLosClientes() {
        return clienteRepository.findAll().stream()
                .map(ClienteDTO::new)
                .collect(Collectors.toList());
    }



    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id) {
        Optional<Cliente> cliente= clienteService.obtenerClientePorId(id);
        return cliente.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente) {
       return ResponseEntity.ok(clienteService.guardarCliente(cliente));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.obtenerClientePorId(id);
        if (cliente.isPresent()) {
            clienteService.eliminarCliente(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}














