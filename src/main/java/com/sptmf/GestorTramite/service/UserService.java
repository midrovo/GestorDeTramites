package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.dto.UserDTO;
import com.sptmf.GestorTramite.dto.UserRolDTO;
import com.sptmf.GestorTramite.interfaces.UserInterface;
import com.sptmf.GestorTramite.mapper.UserModelMapper;
import com.sptmf.GestorTramite.model.Role;
import com.sptmf.GestorTramite.model.User;
import com.sptmf.GestorTramite.repository.RolRepository;
import com.sptmf.GestorTramite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserInterface {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserModelMapper userModelMapper;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> getByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Boolean isValidatedByUsernameAndPassword(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsernameAndPassword(username, password);

        return userOptional.isPresent();
    }

    @Override
    public User create(UserDTO userDTO) {
        Optional<Role> roleOptional = rolRepository.findByName(userDTO.getNameRol());
        Role role = roleOptional.orElse(null);

        User user = userModelMapper.toUser(userDTO);
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return getById(user.getId()).isPresent() ? userRepository.save(user) : null;
    }

    @Override
    public User delete(Long id) {
        Optional<User> userOptional = getById(id);

        if(userOptional.isPresent()) {
            User user = userOptional.get();
            userRepository.delete(user);
            return user;
        }
        return null;
    }

    @Override
    public UserRolDTO userAuth(String username, String password) {
        Optional<User> userOptional = getByUsernameAndPassword(username, password);

        return userOptional.map(value -> userModelMapper.toUserRolDTO(value)).orElse(null);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

}
