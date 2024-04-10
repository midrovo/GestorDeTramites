package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoInterface {
    List<Empleado> getAll();
    Optional<Empleado> getById(Long id);
    Optional<Empleado> getByCedula(String cedula);
    Empleado create(Empleado empleado);
    Empleado update(Empleado empleado);
    Empleado delete(Long id);
}

