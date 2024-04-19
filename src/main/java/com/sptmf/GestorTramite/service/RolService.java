package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.dto.RolDTO;
import com.sptmf.GestorTramite.interfaces.RolInterface;
import com.sptmf.GestorTramite.mapper.RolModelMapper;
import com.sptmf.GestorTramite.model.Permiso;
import com.sptmf.GestorTramite.model.Role;
import com.sptmf.GestorTramite.repository.PermisoRepository;
import com.sptmf.GestorTramite.repository.RolRepository;
import com.sptmf.GestorTramite.util.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RolService implements RolInterface {
    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PermisoRepository permisoRepository;

    @Autowired
    private RolModelMapper rolModelMapper;

    @Override
    public List<Role> getAll() {
        return rolRepository.findAll();
    }

    @Override
    public Optional<Role> getById(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public Optional<Role> getByName(RoleEnum name) {
        return rolRepository.findByName(name);
    }

    @Override
    public Role create(RolDTO rolDTO) {
        Set<Permiso> permisos = new HashSet<>();

        rolDTO.getPermisos().forEach(permiso -> permisos.add(permisoRepository.findByName(permiso).orElse(null)));

        Role role = rolModelMapper.toRole(rolDTO);
        role.setPermisos(permisos);

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
