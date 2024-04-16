package com.sptmf.GestorTramite.mapper;

import com.sptmf.GestorTramite.dto.ClienteTramiteDTO;
import com.sptmf.GestorTramite.dto.UserDTO;
import com.sptmf.GestorTramite.dto.UserRolDTO;
import com.sptmf.GestorTramite.interfaces.mapper.UserMapperInterface;
import com.sptmf.GestorTramite.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserModelMapper implements UserMapperInterface {
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public User toUser(UserDTO userDTO) {
        return mapper.map(userDTO, User.class);
    }

    @Override
    public UserRolDTO toUserRolDTO(User user) {
        return mapper.map(user, UserRolDTO.class);
    }
}
