package com.sptmf.GestorTramite.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.util.Map;


@Data
@EqualsAndHashCode(callSuper = true)
public class CustomException extends Exception {
    private final Boolean error = true;
    private Map<String, String> result;
    private HttpStatus status;
    private String code;

    public CustomException(String message, HttpStatus status, String code) {
        super(message);
        this.status = status;
        this.code = code;
    }

    public CustomException(String message, Map<String, String> result, HttpStatus status, String code) {
        super(message);
        this.result = result;
        this.status = status;
        this.code = code;
    }
}
