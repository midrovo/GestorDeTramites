package com.sptmf.GestorTramite.dto;

import com.sptmf.GestorTramite.util.RoleEnum;
import com.sptmf.GestorTramite.validation.ExistsByUsername;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
public class EmpleadoCreateDTO implements Serializable {
    @ExistsByUsername
    @NotBlank
    private String username; // LOS EMPLEADOS ACCEDEN CON NOMBRE DE USUARIO
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private String cedula;
    @NotNull
    private DepartamentoDTO departamento;
    @NotNull
    private Set<RoleEnum> roles;
}
