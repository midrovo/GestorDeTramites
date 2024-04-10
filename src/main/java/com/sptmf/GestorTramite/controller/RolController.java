package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.exception.CustomException;
import com.sptmf.GestorTramite.model.Rol;
import com.sptmf.GestorTramite.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rol")
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping(value = "/mostrar")
    public ResponseEntity<List<Rol>> getRols() {
        return new ResponseEntity<List<Rol>>(rolService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscar/id/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Long id) throws CustomException {
        Optional<Rol> rolOptional = rolService.getById(id);

        if(rolOptional.isPresent())
            return new ResponseEntity<Rol>(rolOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este rol", HttpStatus.NOT_FOUND, "404");

    }

    @GetMapping(value = "/buscar/{name}")
    public ResponseEntity<Rol> getRolByName(@PathVariable String name) throws CustomException {
        Optional<Rol> rolOptional = rolService.getByName(name);

        if(rolOptional.isPresent())
            return new ResponseEntity<Rol>(rolOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este rol", HttpStatus.NOT_FOUND, "404");

    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        return new ResponseEntity<Rol>(rolService.create(rol), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Rol> updateRol(@RequestBody Rol rol) throws CustomException {
        Rol rolActualizado = rolService.update(rol);

        if(rolActualizado == null)
            throw new CustomException("No se pudo actualizar el rol", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<Rol>(rolActualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "eliminar/{id}")
    public ResponseEntity<Rol> deleteRol(@PathVariable Long id) throws CustomException {
        Rol rolEliminado = rolService.delete(id);

        if(rolEliminado == null)
            throw new CustomException("No se pudo eliminar el rol", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<Rol>(rolEliminado, HttpStatus.OK);
    }
}
