package com.sptmf.GestorTramite.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserRolDTO implements Serializable {
    private String username;
    private String rol;
}
