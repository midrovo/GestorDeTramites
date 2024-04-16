package com.sptmf.GestorTramite.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ErrorDTO {
    private final boolean error;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Map<String, String> result;
    private final String code;
}
