package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.User;

import java.util.List;

public interface UserInterface {
    List<User> getUsers();
    User getUserByCedula(String cedula);
    User getUserById(Long id);
    User getValidatedUser(String username, String password);
    User createUser(User user);
    User updateUser(String cedula, User user);
    void deleteUser(User user);
}
