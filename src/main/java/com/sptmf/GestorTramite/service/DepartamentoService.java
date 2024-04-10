package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.DepartamentoInterface;
import com.sptmf.GestorTramite.model.Departamento;
import com.sptmf.GestorTramite.model.Empleado;
import com.sptmf.GestorTramite.repository.DepartamentoRepository;
import com.sptmf.GestorTramite.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService implements DepartamentoInterface {
    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public List<Departamento> getAll() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento getById(Long id) {
        return null;
    }

    @Override
    public Departamento create(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento update(Departamento departamento) {
        return null;
    }

    @Override
    public Departamento delete(Long id) {
        return null;
    }
}
