package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.CategoriaInterface;
import com.sptmf.GestorTramite.model.Categoria;
import com.sptmf.GestorTramite.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements CategoriaInterface {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> getById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Optional<Categoria> getByName(String name) {
        return categoriaRepository.findByDetail(name);
    }

    @Override
    public Categoria create(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria) {
        return getById(categoria.getId()).isPresent() ? categoriaRepository.save(categoria) : null;
    }

    @Override
    public Categoria delete(Long id) {
        Optional<Categoria> categoriaOptional = getById(id);

        if(categoriaOptional.isPresent()) {
            Categoria categoria = categoriaOptional.get();
            categoriaRepository.delete(categoria);
            return categoria;
        }

        return null;
    }
}
