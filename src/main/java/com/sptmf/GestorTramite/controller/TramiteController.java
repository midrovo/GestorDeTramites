package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.model.Tramite;
import com.sptmf.GestorTramite.service.TramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tramite")
public class TramiteController {
    @Autowired
    TramiteService tramiteService;

    @GetMapping(value = "/mostrar-tramites")
    public ResponseEntity<List<Tramite>> getAllTramites() {
        return ResponseEntity.ok(tramiteService.getTramites());
    }

    @PostMapping(value = "/crear-tramite")
    public ResponseEntity<Tramite> createTramite(@RequestBody Tramite tramite) {
        return ResponseEntity.ok(tramiteService.createTramite(tramite));
    }
}
