package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.EmpleadoInterface;
import com.sptmf.GestorTramite.model.Departamento;
import com.sptmf.GestorTramite.model.Empleado;
import com.sptmf.GestorTramite.repository.DepartamentoRepository;
import com.sptmf.GestorTramite.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements EmpleadoInterface {
    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    DepartamentoRepository  departamentoRepository;

    @Override
    public List<Empleado> getEmployees() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado createEmployee(Empleado empleado) {
        //Departamento departamento = departamentoRepository.findById(empleado.getDepartamento().getId()).orElse(null);

        //if(departamento == null) return null;

        return empleadoRepository.save(empleado);
    }
}
