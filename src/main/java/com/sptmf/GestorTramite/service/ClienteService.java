package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.dto.ClienteCreateDTO;
import com.sptmf.GestorTramite.dto.ClienteTramiteDTO;
import com.sptmf.GestorTramite.interfaces.ClienteInterface;
import com.sptmf.GestorTramite.mapper.ClientModelMapper;
import com.sptmf.GestorTramite.model.Cliente;
import com.sptmf.GestorTramite.model.Role;
import com.sptmf.GestorTramite.model.User;
import com.sptmf.GestorTramite.repository.ClienteRepository;
import com.sptmf.GestorTramite.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements ClienteInterface {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ClientModelMapper clientModelMapper;

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Optional<Cliente> getByCedula(String cedula) {
        return clienteRepository.findByCedula(cedula);
    }

    @Override
    public Cliente create(ClienteCreateDTO clienteCreateDTO) {
        User user = setUserAndRol(clienteCreateDTO.getCedula(), clienteCreateDTO.getPhone());

        Cliente cliente = clientModelMapper.toCliente(clienteCreateDTO);
        cliente.setUser(user);

        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return getById(cliente.getId()) .isPresent() ? clienteRepository.save(cliente) : null;
    }

    @Override
    public Cliente delete(Long id) {
        Optional<Cliente> clienteOptional = getById(id);

        if(clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            clienteRepository.delete(cliente);
            return cliente;
        };

        return null;
    }

    @Override
    public ClienteTramiteDTO clientTramite(String cedula) {
        Optional<Cliente> clienteOptional = getByCedula(cedula);

        return clienteOptional.map(value -> clientModelMapper.toClienteTramiteDto(value)).orElse(null);
    }

    public User setUserAndRol(String username, String password) {
        Optional<Role> roleOptional = rolRepository.findByName("ROLE_CLIENTE");
        Role ROLE_CLIENT = roleOptional.orElse(null);
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(ROLE_CLIENT);

        return user;
    }
}
