package com.sptmf.GestorTramite.mapper;

import com.sptmf.GestorTramite.dto.ClienteCreateDTO;
import com.sptmf.GestorTramite.dto.ClienteTramiteDTO;
import com.sptmf.GestorTramite.interfaces.mapper.ClientMapperInterface;
import com.sptmf.GestorTramite.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ClientModelMapper implements ClientMapperInterface {
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public ClienteTramiteDTO toClienteTramiteDto(Cliente cliente) {
        return mapper.map(cliente, ClienteTramiteDTO.class);
    }

    @Override
    public Cliente toCliente(ClienteCreateDTO clienteCreateDTO) {
        return mapper.map(clienteCreateDTO, Cliente.class);
    }

}
