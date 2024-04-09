package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.UserInterface;
import com.sptmf.GestorTramite.model.User;
import com.sptmf.GestorTramite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserInterface {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByCedula(String cedula) {
        //User usuario = userRepository.findByCedula(cedula);
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getValidatedUser(String username, String password) {
        return null;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String cedula, User user) {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }
}
