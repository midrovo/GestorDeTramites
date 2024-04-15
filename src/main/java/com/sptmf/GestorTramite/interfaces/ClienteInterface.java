package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.dto.ClienteCreateDTO;
import com.sptmf.GestorTramite.dto.ClienteTramiteDTO;
import com.sptmf.GestorTramite.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteInterface {
    List<Cliente> getAll();
    Optional<Cliente> getById(Long id);
    Optional<Cliente> getByCedula(String cedula);
    Cliente create(ClienteCreateDTO clienteCreateDTO);
    Cliente update(Cliente cliente);
    Cliente delete(Long id);
    ClienteTramiteDTO clientTramite(String cedula);
}
