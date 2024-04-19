package com.sptmf.GestorTramite.dto;

import com.sptmf.GestorTramite.util.RoleEnum;
import com.sptmf.GestorTramite.validation.ExistsByUsername;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class UserDTO {
    @NotBlank
    @ExistsByUsername
    private String username;
    @NotBlank
    private String password;
    @NotNull
    private Set<RoleEnum> roles;
}
