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

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserInterface {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserModelMapper userModelMapper;

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
        Set<Role> roles = new HashSet<>();

        userDTO.getRoles().forEach(rol -> roles.add(rolRepository.findByName(rol).orElse(null)));

        User user = userModelMapper.toUser(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(roles);
        user.setEnabled(true);
        user.setAccountNoExpired(true);
        user.setAccountNoLocked(true);
        user.setCredentialNoExpired(true);

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
