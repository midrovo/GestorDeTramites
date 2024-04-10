package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.User;

import java.util.List;

public interface UserInterface {
    List<User> getAll();
    User getById(Long id);
    User create(User user);
    User update(User user);
    User delete(Long id);
}
