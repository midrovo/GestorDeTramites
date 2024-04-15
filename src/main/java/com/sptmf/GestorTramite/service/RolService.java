package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.RolInterface;
import com.sptmf.GestorTramite.model.Role;
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
    public List<Role> getAll() {
        return rolRepository.findAll();
    }

    @Override
    public Optional<Role> getById(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public Optional<Role> getByName(String name) {
        return rolRepository.findByName(name);
    }

    @Override
    public Role create(Role role) {
        return rolRepository.save(role);
    }

    @Override
    public Role update(Role role) {
        return getById(role.getId()).isPresent() ? rolRepository.save(role) : null;
    }

    @Override
    public Role delete(Long id) {
        Optional<Role> rolOptional = getById(id);

        if(rolOptional.isPresent()) {
            Role role = rolOptional.get();
            rolRepository.delete(role);
            return role;
        }

        return null;
    }
}
