package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Role;

import java.util.List;
import java.util.Optional;

public interface RolInterface {
    List<Role> getAll();
    Optional<Role> getById(Long id);
    Optional<Role> getByName(String name);
    Role create(Role role);
    Role update(Role role);
    Role delete(Long id);
}
