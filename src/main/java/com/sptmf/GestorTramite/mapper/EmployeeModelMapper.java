package com.sptmf.GestorTramite.mapper;

import com.sptmf.GestorTramite.dto.EmpleadoCreateDTO;
import com.sptmf.GestorTramite.interfaces.mapper.EmployeeMapperInterface;
import com.sptmf.GestorTramite.model.Empleado;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeModelMapper implements EmployeeMapperInterface {
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public Empleado toEmpleado(EmpleadoCreateDTO empleadoCreateDTO) {
        return mapper.map(empleadoCreateDTO, Empleado.class);
    }
}
