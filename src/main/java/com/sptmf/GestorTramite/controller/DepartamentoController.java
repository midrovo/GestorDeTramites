package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.model.Departamento;
import com.sptmf.GestorTramite.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamento")
public class DepartamentoController {
    @Autowired
    DepartamentoService departamentoService;

    @GetMapping(value = "/mostrar-departamentos")
    public ResponseEntity<List<Departamento>> getDepartaments() {
        return ResponseEntity.ok(departamentoService.getAll());
    }

    @PostMapping(value = "/crear-departamento")
    public ResponseEntity<Departamento> createDepartament(@RequestBody Departamento departamento) {
        return ResponseEntity.ok(departamentoService.create(departamento));
    }
}
