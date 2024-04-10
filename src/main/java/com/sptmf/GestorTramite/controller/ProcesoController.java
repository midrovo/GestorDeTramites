package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.model.Proceso;
import com.sptmf.GestorTramite.service.ProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proceso")
public class ProcesoController {
    @Autowired
    ProcesoService procesoService;

    @GetMapping(value = "/mostrar-procesos")
    public ResponseEntity<List<Proceso>> getProcesses() {
        return ResponseEntity.ok(procesoService.getAll());
    }

    @PostMapping(value = "/crear-proceso")
    public ResponseEntity<Proceso> createProcess(@RequestBody Proceso proceso) {
        return ResponseEntity.ok(procesoService.create(proceso));
    }
}
