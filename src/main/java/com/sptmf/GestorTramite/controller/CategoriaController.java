package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.exception.CustomException;
import com.sptmf.GestorTramite.model.Categoria;
import com.sptmf.GestorTramite.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/mostrar")
    public ResponseEntity<List<Categoria>> getCategories() {
        return new ResponseEntity<List<Categoria>>(categoriaService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscar/id/{id}")
    public ResponseEntity<Categoria> getCategoryById(@PathVariable Long id) throws CustomException {
        Optional<Categoria> categoriaOptional = categoriaService.getById(id);

        if(categoriaOptional.isPresent())
            return new ResponseEntity<Categoria>(categoriaOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe esta categoria", HttpStatus.NOT_FOUND, "404");

    }

    @GetMapping(value = "/buscar/{name}")
    public ResponseEntity<Categoria> getCategoryByName(@PathVariable String name) throws CustomException {
        Optional<Categoria> categoriaOptional = categoriaService.getByName(name);

        if(categoriaOptional.isPresent())
            return new ResponseEntity<Categoria>(categoriaOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe esta categoria", HttpStatus.NOT_FOUND, "404");

    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Categoria> createCategory(@RequestBody Categoria categoria) {
        return new ResponseEntity<Categoria>(categoriaService.create(categoria), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Categoria> updateCategory(@RequestBody Categoria categoria) throws CustomException {
        Categoria categoriaActualizada = categoriaService.update(categoria);

        if(categoriaActualizada == null)
            throw new CustomException("No se pudo actualizar la categoria", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<Categoria>(categoriaActualizada, HttpStatus.OK);
    }

    @DeleteMapping(value = "eliminar/{id}")
    public ResponseEntity<Categoria> deleteCategory(@PathVariable Long id) throws CustomException {
        Categoria categoriaEliminada = categoriaService.delete(id);

        if(categoriaEliminada == null)
            throw new CustomException("No se pudo eliminar la categoria", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<Categoria>(categoriaEliminada, HttpStatus.OK);
    }
}
