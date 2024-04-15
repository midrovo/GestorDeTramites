package com.sptmf.GestorTramite.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class EmpleadoCreateDTO implements Serializable {
    private String name;
    private String lastname;
    private String cedula;
    private String nameRol;
    private DepartamentoDTO departamento;
}
