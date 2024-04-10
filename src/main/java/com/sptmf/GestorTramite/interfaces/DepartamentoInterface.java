package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Departamento;

import java.util.List;
import java.util.Optional;

public interface DepartamentoInterface {
    List<Departamento> getAll();
    Optional<Departamento> getById(Long id);
    Optional<Departamento> getByName(String name);
    Departamento create(Departamento departamento);
    Departamento update(Departamento departamento);
    Departamento delete(Long id);
}

