package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.exception.CustomException;
import com.sptmf.GestorTramite.model.Proceso;
import com.sptmf.GestorTramite.service.ProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/procesos")
public class ProcesoController {
    @Autowired
    private ProcesoService procesoService;

    @GetMapping(value = "/mostrar")
    public ResponseEntity<List<Proceso>> getProcesses() {
        return new ResponseEntity<List<Proceso>>(procesoService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscar/id/{id}")
    public ResponseEntity<Proceso> getProcessById(@PathVariable Long id) throws CustomException, MissingPathVariableException {
        Optional<Proceso> procesoOptional = procesoService.getById(id);

        if(procesoOptional.isPresent())
            return new ResponseEntity<Proceso>(procesoOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este proceso", HttpStatus.NOT_FOUND, "404");

    }

    @GetMapping(value = "/buscar/{name}")
    public ResponseEntity<Proceso> getProcessByName(@PathVariable String name) throws CustomException {
        Optional<Proceso> procesoOptional = procesoService.getByName(name);

        if(procesoOptional.isPresent())
            return new ResponseEntity<Proceso>(procesoOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este proceso", HttpStatus.NOT_FOUND, "404");

    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Proceso> createProcess(@RequestBody Proceso proceso) {
        return new ResponseEntity<Proceso>(procesoService.create(proceso), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Proceso> updateProcess(@RequestBody Proceso proceso) throws CustomException {
        Proceso procesoActualizado = procesoService.update(proceso);

        if(procesoActualizado == null)
            throw new CustomException("No se pudo actualizar el proceso", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<Proceso>(procesoActualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "eliminar/{id}")
    public ResponseEntity<Proceso> deleteProcess(@PathVariable Long id) throws CustomException {
        Proceso procesoEliminado = procesoService.delete(id);

        if(procesoEliminado == null)
            throw new CustomException("No se pudo eliminar el proceso", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<Proceso>(procesoEliminado, HttpStatus.OK);
    }
}
