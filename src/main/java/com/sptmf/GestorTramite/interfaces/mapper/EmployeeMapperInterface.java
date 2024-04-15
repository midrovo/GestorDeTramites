package com.sptmf.GestorTramite.interfaces.mapper;

import com.sptmf.GestorTramite.dto.EmpleadoCreateDTO;
import com.sptmf.GestorTramite.model.Empleado;

public interface EmployeeMapperInterface {
    Empleado toEmpleado(EmpleadoCreateDTO empleadoCreateDTO);
}
