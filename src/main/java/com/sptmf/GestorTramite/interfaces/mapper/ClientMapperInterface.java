package com.sptmf.GestorTramite.interfaces.mapper;

import com.sptmf.GestorTramite.dto.ClienteCreateDTO;
import com.sptmf.GestorTramite.dto.ClienteTramiteDTO;
import com.sptmf.GestorTramite.model.Cliente;

public interface ClientMapperInterface {
    ClienteTramiteDTO toClienteTramiteDto(Cliente cliente);
    Cliente toCliente(ClienteCreateDTO clienteCreateDTO);
}
