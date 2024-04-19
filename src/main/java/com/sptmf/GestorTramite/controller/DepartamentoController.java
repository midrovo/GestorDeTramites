package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.exception.CustomException;
import com.sptmf.GestorTramite.model.Departamento;
import com.sptmf.GestorTramite.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping(value = "/mostrar")
    public ResponseEntity<List<Departamento>> getDepartaments() {
        return new ResponseEntity<List<Departamento>>(departamentoService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscar/id/{id}")
    public ResponseEntity<Departamento> getDepartamentById(@PathVariable Long id) throws CustomException {
        Optional<Departamento> departamentoOptional = departamentoService.getById(id);

        if(departamentoOptional.isPresent())
            return new ResponseEntity<Departamento>(departamentoOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este cliente", HttpStatus.NOT_FOUND, "404");

    }

    @GetMapping(value = "/buscar/{name}")
    public ResponseEntity<Departamento> getDepartamentByName(@PathVariable String name) throws CustomException {
        Optional<Departamento> departamentoOptional = departamentoService.getByName(name);

        if(departamentoOptional.isPresent())
            return new ResponseEntity<Departamento>(departamentoOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este departamento", HttpStatus.NOT_FOUND, "404");

    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Departamento> createDepartament(@RequestBody Departamento departamento) {
        return new ResponseEntity<Departamento>(departamentoService.create(departamento), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Departamento> updateDepartament(@RequestBody Departamento departamento) throws CustomException {
        Departamento departamentoActualizado = departamentoService.update(departamento);

        if(departamentoActualizado == null)
            throw new CustomException("No se pudo actualizar el departamento", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<Departamento>(departamentoActualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "eliminar/{id}")
    public ResponseEntity<Departamento> deleteDepartament(@PathVariable Long id) throws CustomException {
        Departamento departamentoEliminado = departamentoService.delete(id);

        if(departamentoEliminado == null)
            throw new CustomException("No se pudo eliminar el departamento", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<Departamento>(departamentoEliminado, HttpStatus.OK);
    }
}
