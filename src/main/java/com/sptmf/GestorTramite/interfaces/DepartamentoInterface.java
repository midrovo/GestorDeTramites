package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Departamento;

import java.util.List;

public interface DepartamentoInterface {
    List<Departamento> getAll();
    Departamento getById(Long id);
    Departamento create(Departamento departamento);
    Departamento update(Departamento departamento);
    Departamento delete(Long id);
}

