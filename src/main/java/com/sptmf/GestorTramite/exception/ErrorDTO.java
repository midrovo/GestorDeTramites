package com.sptmf.GestorTramite.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private final String message;
    private final String code;
}
