package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.dto.UserDTO;
import com.sptmf.GestorTramite.dto.UserRolDTO;
import com.sptmf.GestorTramite.model.User;

import java.util.List;
import java.util.Optional;

public interface UserInterface {
    List<User> getAll();
    Optional<User> getById(Long id);
    Optional<User> getByUsername(String username);
    Optional<User> getByUsernameAndPassword(String username, String password);
    Boolean isValidatedByUsernameAndPassword(String username, String password);
    User create(UserDTO userDTO);
    User update(User user);
    User delete(Long id);
    UserRolDTO userAuth(String username, String password);
    Boolean existsByUsername(String username);
}
