package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.exception.CustomException;
import com.sptmf.GestorTramite.model.Categoria;
import com.sptmf.GestorTramite.model.Permiso;
import com.sptmf.GestorTramite.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {
    @Autowired
    PermisoService permisoService;

    @GetMapping(value = "/mostrar")
    public ResponseEntity<List<Permiso>> getPermisos() {
        return new ResponseEntity<List<Permiso>>(permisoService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscar/id/{id}")
    public ResponseEntity<Permiso> getPermisoById(@PathVariable Long id) throws CustomException {
        Optional<Permiso> permisoOptional = permisoService.getById(id);

        if(permisoOptional.isPresent())
            return new ResponseEntity<Permiso>(permisoOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este permiso", HttpStatus.NOT_FOUND, "404");

    }

    @GetMapping(value = "/buscar/{name}")
    public ResponseEntity<Permiso> getPermisoByName(@PathVariable String name) throws CustomException {
        Optional<Permiso> permisoOptional = permisoService.getByName(name);

        if(permisoOptional.isPresent())
            return new ResponseEntity<Permiso>(permisoOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este permiso", HttpStatus.NOT_FOUND, "404");

    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Permiso> createPermiso(@RequestBody Permiso permiso) {
        return new ResponseEntity<Permiso>(permisoService.create(permiso), HttpStatus.CREATED);
    }
}
