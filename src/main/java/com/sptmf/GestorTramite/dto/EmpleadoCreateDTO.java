package com.sptmf.GestorTramite.dto;

import com.sptmf.GestorTramite.validation.ExistsByUsername;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class EmpleadoCreateDTO implements Serializable {
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private String cedula;
    @NotBlank
    private String nameRol;
    @NotNull
    private DepartamentoDTO departamento;
    @ExistsByUsername
    @NotBlank
    private String username;
}
