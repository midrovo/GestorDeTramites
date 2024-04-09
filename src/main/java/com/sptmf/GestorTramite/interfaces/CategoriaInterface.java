package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Categoria;

import java.util.List;

public interface CategoriaInterface {
    List<Categoria> getCategories();
    Categoria createCategory(Categoria categoria);
}
