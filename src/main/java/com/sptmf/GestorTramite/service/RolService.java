package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.RolInterface;
import com.sptmf.GestorTramite.model.Rol;
import com.sptmf.GestorTramite.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements RolInterface {
    @Autowired
    RolRepository rolRepository;
    @Override
    public List<Rol> getAll() {
        return rolRepository.findAll();
    }

    @Override
    public Rol getById(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public Rol create(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol update(Rol rol) {
        return null;
    }

    @Override
    public Rol delete(Long id) {
        Rol rol = getById(id);

        if(rol == null) {
            return null;
        }
        rolRepository.delete(rol);
        return rol;
    }
}
