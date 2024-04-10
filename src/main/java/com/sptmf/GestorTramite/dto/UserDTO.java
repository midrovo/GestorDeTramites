package com.sptmf.GestorTramite.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private final String username;
    private final String name;
    private final String password;

}
