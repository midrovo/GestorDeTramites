package com.sptmf.GestorTramite.interfaces.mapper;

import com.sptmf.GestorTramite.dto.ClienteTramiteDTO;
import com.sptmf.GestorTramite.dto.UserRolDTO;
import com.sptmf.GestorTramite.model.User;

public interface UserMapperInterface {
    ClienteTramiteDTO toUserDTO(User user);
    UserRolDTO toUserRolDTO(User user);
}
