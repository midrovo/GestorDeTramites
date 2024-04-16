package com.sptmf.GestorTramite.dto;

import com.sptmf.GestorTramite.validation.ExistsByUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ClienteCreateDTO implements Serializable {
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    @ExistsByUsername
    private String cedula; //SOLO LOS CLIENTES SE LES APLICA LA CEDULA COMO NOMBRE DE USUARIO
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String city;
    @NotBlank
    private String address;
}
