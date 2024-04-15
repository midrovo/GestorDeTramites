package com.sptmf.GestorTramite.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ClienteCreateDTO implements Serializable {
    private String name;
    private String lastname;
    private String cedula;
    private String email;
    private String phone;
    private String city;
    private String address;
}
