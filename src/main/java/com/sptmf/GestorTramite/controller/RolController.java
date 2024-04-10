package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.model.Rol;
import com.sptmf.GestorTramite.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolController {
    @Autowired
    RolService rolService;

    @GetMapping(value = "/mostrar-roles")
    public ResponseEntity<List<Rol>> getRols() {
        return ResponseEntity.ok(rolService.getAll());
    }

    @PostMapping(value = "/crear-rol")
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        return ResponseEntity.ok(rolService.create(rol));
    }
}
