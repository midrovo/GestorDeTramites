package com.sptmf.GestorTramite.mapper;

import com.sptmf.GestorTramite.dto.RolDTO;
import com.sptmf.GestorTramite.interfaces.mapper.RolMapperInterface;
import com.sptmf.GestorTramite.model.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RolModelMapper implements RolMapperInterface {
    private final ModelMapper mapper = new ModelMapper();


    @Override
    public Role toRole(RolDTO rolDTO) {
        return mapper.map(rolDTO, Role.class);
    }
}
