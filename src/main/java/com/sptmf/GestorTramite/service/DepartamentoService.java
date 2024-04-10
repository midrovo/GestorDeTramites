package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.DepartamentoInterface;
import com.sptmf.GestorTramite.model.Departamento;
import com.sptmf.GestorTramite.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService implements DepartamentoInterface {
    @Autowired
    DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> getAll() {
        return departamentoRepository.findAll();
    }

    @Override
    public Optional<Departamento> getById(Long id) {
        return departamentoRepository.findById(id);
    }

    @Override
    public Departamento create(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento update(Departamento departamento) {
        return getById(departamento.getId()).isPresent() ? departamentoRepository.save(departamento) : null;
    }

    @Override
    public Departamento delete(Long id) {
        Optional<Departamento> departamentoOptional = getById(id);

        if(departamentoOptional.isPresent()) {
            Departamento departamento = departamentoOptional.get();
            departamentoRepository.delete(departamento);
            return departamento;
        }

        return null;
    }
}

