package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaInterface {
    List<Categoria> getAll();
    Optional<Categoria>  getById(Long id);
    Optional<Categoria> getByName(String name);
    Categoria create(Categoria categoria);
    Categoria update(Categoria categoria);
    Categoria delete(Long id);
}
