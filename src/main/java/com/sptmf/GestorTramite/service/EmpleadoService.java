package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.EmpleadoInterface;
import com.sptmf.GestorTramite.model.Empleado;
import com.sptmf.GestorTramite.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements EmpleadoInterface {
    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> getEmployees() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado createEmployee(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
}
