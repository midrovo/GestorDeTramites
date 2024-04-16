package com.sptmf.GestorTramite.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartamentoDTO {
    @NotNull
    private Long id;
}
