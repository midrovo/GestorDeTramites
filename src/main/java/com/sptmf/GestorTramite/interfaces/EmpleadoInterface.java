package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Empleado;

import java.util.List;

public interface EmpleadoInterface {
    List<Empleado> getAll();
    Empleado getById(Long id);
    Empleado create(Empleado empleado);
    Empleado update(Empleado empleado);
    Empleado delete(Long id);
}

