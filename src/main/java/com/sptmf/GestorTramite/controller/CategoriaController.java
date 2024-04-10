package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.model.Categoria;
import com.sptmf.GestorTramite.repository.CategoriaRepository;
import com.sptmf.GestorTramite.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping(value = "/mostrar-categorias")
    public ResponseEntity<List<Categoria>> getAllCategories() {
        return ResponseEntity.ok(categoriaService.getAll());
    }

    @PostMapping(value = "/crear-categoria")
    public ResponseEntity<Categoria> createCategory(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.create(categoria));
    }
}
