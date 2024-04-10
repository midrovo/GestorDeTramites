package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Cliente;

import java.util.List;

public interface ClienteInterface {
    List<Cliente> getAll();
    Cliente getById(Long id);
    Cliente create(Cliente cliente);
    Cliente update(Cliente cliente);
    Cliente delete(Long id);
}
