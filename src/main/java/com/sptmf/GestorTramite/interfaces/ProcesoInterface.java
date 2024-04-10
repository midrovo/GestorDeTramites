package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Proceso;

import java.util.List;
import java.util.Optional;

public interface ProcesoInterface {
    List<Proceso> getAll();
    Optional<Proceso> getById(Long id);
    Optional<Proceso> getByName(String name);
    Proceso create(Proceso proceso);
    Proceso update(Proceso proceso);
    Proceso delete(Long id);
}
