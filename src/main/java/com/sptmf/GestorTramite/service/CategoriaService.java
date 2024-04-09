package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.CategoriaInterface;
import com.sptmf.GestorTramite.model.Categoria;
import com.sptmf.GestorTramite.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements CategoriaInterface {
    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> getCategories() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria createCategory(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
