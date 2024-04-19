package com.sptmf.GestorTramite.interfaces.mapper;

import com.sptmf.GestorTramite.dto.RolDTO;
import com.sptmf.GestorTramite.model.Role;

public interface RolMapperInterface {
    Role toRole(RolDTO rolDTO);
}
