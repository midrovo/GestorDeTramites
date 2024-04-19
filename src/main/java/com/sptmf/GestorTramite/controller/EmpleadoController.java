package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.dto.EmpleadoCreateDTO;
import com.sptmf.GestorTramite.exception.CustomException;
import com.sptmf.GestorTramite.model.Empleado;
import com.sptmf.GestorTramite.model.User;
import com.sptmf.GestorTramite.service.EmpleadoService;
import com.sptmf.GestorTramite.service.UserService;
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
@RequestMapping("/api/empleados")
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

    @GetMapping(value = "/{username}")
    public ResponseEntity<Empleado> getEmployeeByUsername(@PathVariable String username) throws CustomException {
        Optional<Empleado> empleadoOptional = empleadoService.getByUsername(username);

        if(empleadoOptional.isPresent()) {
            return new ResponseEntity<Empleado>(empleadoOptional.get(), HttpStatus.OK);
        }

        throw new CustomException("No existe este empleado", HttpStatus.NOT_FOUND, "404");

    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Empleado> createEmployee(@Valid @RequestBody EmpleadoCreateDTO empleadoCreateDTO,
                                                   BindingResult result) throws CustomException {

        if(result.hasFieldErrors()) {
            throw new CustomException("Error de campos", validation(result), HttpStatus.BAD_REQUEST, "400");
        }

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

    private Map<String, String> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });

        return errors;
    }
}
