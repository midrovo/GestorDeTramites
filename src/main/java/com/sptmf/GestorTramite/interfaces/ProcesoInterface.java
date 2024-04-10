package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Proceso;

import java.util.List;

public interface ProcesoInterface {
    List<Proceso> getAll();
    Proceso getById(Long id);
    Proceso create(Proceso proceso);
    Proceso update(Proceso proceso);
    Proceso delete(Long id);
}
