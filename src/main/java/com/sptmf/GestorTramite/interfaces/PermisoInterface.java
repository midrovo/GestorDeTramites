package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Permiso;

import java.util.List;
import java.util.Optional;

public interface PermisoInterface {
    List<Permiso> getAll();
    Optional<Permiso> getById(Long id);
    Optional<Permiso> getByName(String name);
    Permiso create(Permiso permiso);
}
