package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Empleado;

import java.util.List;

public interface EmpleadoInterface {
    List<Empleado> getEmployees();
    Empleado createEmployee(Empleado empleado);
}
