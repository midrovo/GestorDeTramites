package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.dto.ClienteCreateDTO;
import com.sptmf.GestorTramite.dto.ClienteTramiteDTO;
import com.sptmf.GestorTramite.exception.CustomException;
import com.sptmf.GestorTramite.model.Cliente;
import com.sptmf.GestorTramite.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
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

//    @GetMapping(value = "/buscar/{cedula}")
//    public ResponseEntity<Cliente> getClientByCedula(@PathVariable String cedula) throws CustomException {
//        Optional<Cliente> clienteOptional = clienteService.getByCedula(cedula);
//
//        if(clienteOptional.isPresent())
//            return new ResponseEntity<Cliente>(clienteOptional.get(), HttpStatus.OK);
//
//        throw new CustomException("No existe este cliente", HttpStatus.NOT_FOUND, "404");
//
//    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Cliente> createClient(@RequestBody ClienteCreateDTO clienteCreateDTO) {
        return new ResponseEntity<Cliente>(clienteService.create(clienteCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Cliente> updateClient(@RequestBody Cliente cliente) throws CustomException {
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
}
