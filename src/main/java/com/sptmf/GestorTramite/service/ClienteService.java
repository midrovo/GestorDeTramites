package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.ClienteInterface;
import com.sptmf.GestorTramite.model.Cliente;
import com.sptmf.GestorTramite.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements ClienteInterface {
    @Autowired
    private ClienteRepository clienteRepository;

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
    public Cliente create(Cliente cliente) {
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
        };

        return null;
    }
}
