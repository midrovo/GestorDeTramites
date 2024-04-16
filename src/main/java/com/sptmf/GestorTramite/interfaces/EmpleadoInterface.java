package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.dto.EmpleadoCreateDTO;
import com.sptmf.GestorTramite.exception.CustomException;
import com.sptmf.GestorTramite.model.Empleado;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface EmpleadoInterface {
    List<Empleado> getAll();
    Optional<Empleado> getById(Long id);
    Optional<Empleado> getByCedula(String cedula);
    Empleado create(EmpleadoCreateDTO empleadoCreateDTO);
    Empleado update(Empleado empleado);
    Empleado delete(Long id);
}

