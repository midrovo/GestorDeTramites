package com.sptmf.GestorTramite.dto;

import lombok.Builder;
import lombok.Data;

@Builder
public class UserDTO {
    final String username;
    final String name;
    final String password;

}
