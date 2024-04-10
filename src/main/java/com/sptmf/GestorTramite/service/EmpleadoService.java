package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.EmpleadoInterface;
import com.sptmf.GestorTramite.model.Empleado;
import com.sptmf.GestorTramite.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements EmpleadoInterface {
    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> getAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> getById(Long id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public Optional<Empleado> getByCedula(String cedula) {
        return empleadoRepository.findByCedula(cedula);
    }

    @Override
    public Empleado create(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado update(Empleado empleado) {
        return getById(empleado.getId()).isPresent() ? empleadoRepository.save(empleado) : null;
    }

    @Override
    public Empleado delete(Long id) {
        Optional<Empleado> empleadoOptional = getById(id);

        if(empleadoOptional.isPresent()) {
            Empleado empleado = empleadoOptional.get();
            empleadoRepository.delete(empleado);
            return empleado;
        }

        return null;
    }
}
