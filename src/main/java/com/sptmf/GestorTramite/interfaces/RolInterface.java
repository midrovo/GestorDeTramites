package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Rol;

import java.util.List;

public interface RolInterface {
    List<Rol> getAll();
    Rol getById(Long id);
    Rol create(Rol rol);
    Rol update(Rol rol);
    Rol delete(Long id);
}
