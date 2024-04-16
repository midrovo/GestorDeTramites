package com.sptmf.GestorTramite.interfaces.mapper;

import com.sptmf.GestorTramite.dto.ClienteTramiteDTO;
import com.sptmf.GestorTramite.dto.UserDTO;
import com.sptmf.GestorTramite.dto.UserRolDTO;
import com.sptmf.GestorTramite.model.User;

public interface UserMapperInterface {
    User toUser(UserDTO userDTO);
    UserRolDTO toUserRolDTO(User user);
}
