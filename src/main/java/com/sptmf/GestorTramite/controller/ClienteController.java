package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.dto.ClienteCreateDTO;
import com.sptmf.GestorTramite.dto.ClienteTramiteDTO;
import com.sptmf.GestorTramite.exception.CustomException;
import com.sptmf.GestorTramite.model.Cliente;
import com.sptmf.GestorTramite.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/mostrar")
    public ResponseEntity<List<Cliente>> getClients() {
        return new ResponseEntity<List<Cliente>>(clienteService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscar/id/{id}")
    public ResponseEntity<Cliente> getClientById(@PathVariable Long id) throws CustomException {
        Optional<Cliente> clienteOptional = clienteService.getById(id);

        if(clienteOptional.isPresent())
            return new ResponseEntity<Cliente>(clienteOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este cliente", HttpStatus.NOT_FOUND, "404");

    }

    @GetMapping(value = "/buscar/{cedula}")
    public ResponseEntity<ClienteTramiteDTO> getClientByCedula(@PathVariable String cedula) throws CustomException {
        ClienteTramiteDTO clienteTramiteDTO = clienteService.clientTramite(cedula);

        if(clienteTramiteDTO == null)
            throw new CustomException("No existe este cliente", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<ClienteTramiteDTO>(clienteTramiteDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Cliente> createClient(@Valid @RequestBody ClienteCreateDTO clienteCreateDTO,
                                                BindingResult result) throws CustomException {
        if(result.hasFieldErrors()) {
            throw new CustomException("Error de campos", validation(result), HttpStatus.BAD_REQUEST, "400");
        }

        return new ResponseEntity<Cliente>(clienteService.create(clienteCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Cliente> updateClient(@Valid @RequestBody Cliente cliente,
                                                BindingResult result) throws CustomException {
        if(result.hasFieldErrors()) {
            throw new CustomException("Error de campos", validation(result), HttpStatus.BAD_REQUEST, "400");
        }

        Cliente clienteActualizado = clienteService.update(cliente);

        if(clienteActualizado == null)
            throw new CustomException("No se pudo actualizar el cliente", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<Cliente>(clienteActualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "eliminar/{id}")
    public ResponseEntity<Cliente> deleteClient(@PathVariable Long id) throws CustomException {
        Cliente clienteEliminado = clienteService.delete(id);

        if(clienteEliminado == null)
            throw new CustomException("No se pudo eliminar el cliente", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<Cliente>(clienteEliminado, HttpStatus.OK);
    }

    private Map<String, String> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });

        return errors;
    }
}
