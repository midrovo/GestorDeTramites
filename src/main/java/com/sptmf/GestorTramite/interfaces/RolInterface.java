package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Rol;

import java.util.List;

public interface RolInterface {
    List<Rol> getRols();
    Rol createRol(Rol rol);
}
