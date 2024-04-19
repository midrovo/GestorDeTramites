package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.model.User;
import com.sptmf.GestorTramite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);

        User user = userOptional.orElseThrow(
                () -> new UsernameNotFoundException(String.format("El usuario %s no existe", username))
        );

        List<GrantedAuthority> authorities = new ArrayList<>();

        user.getRoles().forEach(rol -> authorities.add(new SimpleGrantedAuthority(
                "ROLE_".concat(String.valueOf(rol.getName()))
        )));

        user.getRoles().stream().flatMap(role -> role.getPermisos().stream())
                .forEach(permiso -> authorities.add(new SimpleGrantedAuthority(permiso.getName())));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                user.isAccountNoExpired(),
                user.isCredentialNoExpired(),
                user.isAccountNoLocked(),
                authorities
                );
    }
}
