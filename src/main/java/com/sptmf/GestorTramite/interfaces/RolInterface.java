package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.dto.RolDTO;
import com.sptmf.GestorTramite.model.Role;
import com.sptmf.GestorTramite.util.RoleEnum;

import java.util.List;
import java.util.Optional;

public interface RolInterface {
    List<Role> getAll();
    Optional<Role> getById(Long id);
    Optional<Role> getByName(RoleEnum name);
    Role create(RolDTO rolDTO);
    Role update(Role role);
    Role delete(Long id);
}
