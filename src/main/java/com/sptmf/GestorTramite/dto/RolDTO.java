package com.sptmf.GestorTramite.dto;

import com.sptmf.GestorTramite.model.Permiso;
import com.sptmf.GestorTramite.util.RoleEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class RolDTO {
    private RoleEnum name;
    private Set<String> permisos;
}
