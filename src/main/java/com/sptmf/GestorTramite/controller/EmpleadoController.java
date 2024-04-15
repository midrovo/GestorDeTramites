package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.dto.EmpleadoCreateDTO;
import com.sptmf.GestorTramite.exception.CustomException;
import com.sptmf.GestorTramite.model.Empleado;
import com.sptmf.GestorTramite.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping(value = "/mostrar")
    public ResponseEntity<List<Empleado>> getEmployees() {
        return new ResponseEntity<List<Empleado>>(empleadoService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscar/id/{id}")
    public ResponseEntity<Empleado> getEmployeeById(@PathVariable Long id) throws CustomException {
        Optional<Empleado> empleadoOptional = empleadoService.getById(id);

        if(empleadoOptional.isPresent())
            return new ResponseEntity<Empleado>(empleadoOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este empleado", HttpStatus.NOT_FOUND, "404");

    }

    @GetMapping(value = "/buscar/{name}")
    public ResponseEntity<Empleado> getEmployeeByName(@PathVariable String cedula) throws CustomException {
        Optional<Empleado> empleadoOptional = empleadoService.getByCedula(cedula);

        if(empleadoOptional.isPresent())
            return new ResponseEntity<Empleado>(empleadoOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este empleado", HttpStatus.NOT_FOUND, "404");

    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Empleado> createEmployee(@RequestBody EmpleadoCreateDTO empleadoCreateDTO) {
        return new ResponseEntity<Empleado>(empleadoService.create(empleadoCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Empleado> updateEmployee(@RequestBody Empleado empleado) throws CustomException {
        Empleado empleadoActualizado = empleadoService.update(empleado);

        if(empleadoActualizado == null)
            throw new CustomException("No se pudo actualizar el empleado", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<Empleado>(empleadoActualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "eliminar/{id}")
    public ResponseEntity<Empleado> deleteEmployee(@PathVariable Long id) throws CustomException {
        Empleado empleadoEliminado = empleadoService.delete(id);

        if(empleadoEliminado == null)
            throw new CustomException("No se pudo eliminar el empleado", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<Empleado>(empleadoEliminado, HttpStatus.OK);
    }
}
