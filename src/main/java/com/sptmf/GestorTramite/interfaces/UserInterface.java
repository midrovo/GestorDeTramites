package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.User;

import java.util.List;
import java.util.Optional;

public interface UserInterface {
    List<User> getAll();
    Optional<User> getById(Long id);
    User create(User user);
    User update(User user);
    User delete(Long id);
}
