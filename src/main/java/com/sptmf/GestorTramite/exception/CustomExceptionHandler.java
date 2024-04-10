package com.sptmf.GestorTramite.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler({ CustomException.class, })
    public ResponseEntity<ErrorDTO> customExceptionHandler(CustomException e) {
        ErrorDTO errorDTO = ErrorDTO.builder().message(e.getMessage()).code(e.getCode()).build();

        return new ResponseEntity<ErrorDTO>(errorDTO, e.getStatus());
    }
}
