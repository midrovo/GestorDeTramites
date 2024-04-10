package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Categoria;

import java.util.List;

public interface CategoriaInterface {
    List<Categoria> getAll();
    Categoria getById(Long id);
    Categoria create(Categoria categoria);
    Categoria update(Categoria categoria);
    Categoria delete(Long id);
}
