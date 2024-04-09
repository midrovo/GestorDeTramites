package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.model.Empleado;
import com.sptmf.GestorTramite.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/mostrar-empleados")
    public ResponseEntity<List<Empleado>> getAllEmployees() {
        return ResponseEntity.ok(empleadoService.getEmployees());
    }

    @PostMapping("/crear-empleado")
    public ResponseEntity<Empleado> createEmployee(@RequestBody Empleado empleado) {
        return ResponseEntity.ok(empleadoService.createEmployee(empleado));
    }
}
