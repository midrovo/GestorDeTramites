package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.PermisoInterface;
import com.sptmf.GestorTramite.model.Permiso;
import com.sptmf.GestorTramite.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisoService implements PermisoInterface {
    @Autowired
    private PermisoRepository permisoRepository;

    @Override
    public List<Permiso> getAll() {
        return permisoRepository.findAll();
    }

    @Override
    public Optional<Permiso> getById(Long id) {
        return permisoRepository.findById(id);
    }

    @Override
    public Optional<Permiso> getByName(String name) {
        return permisoRepository.findByName(name);
    }

    @Override
    public Permiso create(Permiso permiso) {
        return permisoRepository.save(permiso);
    }
}
