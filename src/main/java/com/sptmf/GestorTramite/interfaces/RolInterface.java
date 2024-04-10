package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Rol;

import java.util.List;
import java.util.Optional;

public interface RolInterface {
    List<Rol> getAll();
    Optional<Rol> getById(Long id);
    Rol create(Rol rol);
    Rol update(Rol rol);
    Rol delete(Long id);
}
