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
    public List<Rol> getRols() {
        return rolRepository.findAll();
    }

    @Override
    public Rol createRol(Rol rol) {
        return rolRepository.save(rol);
    }
}
