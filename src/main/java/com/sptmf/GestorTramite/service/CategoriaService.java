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
    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria getById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Categoria create(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria) {
        return null;
    }

    @Override
    public Categoria delete(Long id) {
        Categoria categoria = getById(id);

        if(categoria == null) {
            return null;
        }
        categoriaRepository.delete(categoria);
        return categoria;
    }
}
