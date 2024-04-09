package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.ClienteInterface;
import com.sptmf.GestorTramite.model.Cliente;
import com.sptmf.GestorTramite.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements ClienteInterface {
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getClients() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente createClient(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
