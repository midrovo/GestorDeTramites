package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.exception.CustomException;
import com.sptmf.GestorTramite.model.Tramite;
import com.sptmf.GestorTramite.service.TramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tramites")
public class TramiteController {
    @Autowired
    private TramiteService tramiteService;

    @GetMapping(value = "/mostrar")
    public ResponseEntity<List<Tramite>> getTramites() {
        return new ResponseEntity<List<Tramite>>(tramiteService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscar/id/{id}")
    public ResponseEntity<Tramite> getTramiteById(@PathVariable Long id) throws CustomException {
        Optional<Tramite> tramiteOptional = tramiteService.getById(id);

        if(tramiteOptional.isPresent())
            return new ResponseEntity<Tramite>(tramiteOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este tramite", HttpStatus.NOT_FOUND, "404");

    }

    @GetMapping(value = "/buscar/{name}")
    public ResponseEntity<Tramite> getTramiteByName(@PathVariable String cedula) throws CustomException {
        Optional<Tramite> tramiteOptional = tramiteService.getByName(cedula);

        if(tramiteOptional.isPresent())
            return new ResponseEntity<Tramite>(tramiteOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este tramite", HttpStatus.NOT_FOUND, "404");

    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Tramite> createTramite(@RequestBody Tramite tramite) {
        return new ResponseEntity<Tramite>(tramiteService.create(tramite), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Tramite> updateTramite(@RequestBody Tramite tramite) throws CustomException {
        Tramite tramiteActualizado = tramiteService.update(tramite);

        if(tramiteActualizado == null)
            throw new CustomException("No se pudo actualizar el tramite", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<Tramite>(tramiteActualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "eliminar/{id}")
    public ResponseEntity<Tramite> deleteTramite(@PathVariable Long id) throws CustomException {
        Tramite tramiteEliminado = tramiteService.delete(id);

        if(tramiteEliminado == null)
            throw new CustomException("No se pudo eliminar el tramite", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<Tramite>(tramiteEliminado, HttpStatus.OK);
    }
}
