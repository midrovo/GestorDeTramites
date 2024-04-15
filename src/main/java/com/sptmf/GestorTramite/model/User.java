package com.sptmf.GestorTramite.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_usuario", length = 20, nullable = false, unique = true)
    @NotEmpty
    private String username;

    @Column(name = "clave", nullable = false)
    @NotEmpty
    private String password;

    @OneToOne(mappedBy = "user")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Empleado empleado;

    @OneToOne(mappedBy = "user")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rol_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Role role;

    public void createClient(Cliente cliente) {
        cliente.setUser(this);
    }

    public void createEmployee(Empleado empleado) {
        empleado.setUser(this);
    }
}
