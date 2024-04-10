package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.RolInterface;
import com.sptmf.GestorTramite.model.Rol;
import com.sptmf.GestorTramite.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService implements RolInterface {
    @Autowired
    RolRepository rolRepository;
    @Override
    public List<Rol> getAll() {
        return rolRepository.findAll();
    }

    @Override
    public Optional<Rol> getById(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public Optional<Rol> getByName(String name) {
        return rolRepository.findByRol(name);
    }

    @Override
    public Rol create(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol update(Rol rol) {
        return getById(rol.getId()).isPresent() ? rolRepository.save(rol) : null;
    }

    @Override
    public Rol delete(Long id) {
        Optional<Rol> rolOptional = getById(id);

        if(rolOptional.isPresent()) {
            Rol rol = rolOptional.get();
            rolRepository.delete(rol);
            return rol;
        }

        return null;
    }
}
