package com.sptmf.GestorTramite.dto;

import com.sptmf.GestorTramite.validation.ExistsByUsername;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    @NotBlank
    @ExistsByUsername
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String nameRol;
}
