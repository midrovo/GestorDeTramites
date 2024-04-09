package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.model.Cliente;
import com.sptmf.GestorTramite.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/mostrar-clientes")
    public ResponseEntity<List<Cliente>> getAllClient() {
        return ResponseEntity.ok(clienteService.getClients());
    }

    @PostMapping(value = "/crear-cliente")
    public ResponseEntity<Cliente> createClient(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.createClient((cliente)));
    }
}
