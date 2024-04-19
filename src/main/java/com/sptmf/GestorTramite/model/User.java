package com.sptmf.GestorTramite.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "usuarios")
public class User {
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_usuario", length = 20, nullable = false, unique = true)
    @NotBlank
    private String username;

    @Column(name = "clave", nullable = false)
    @NotEmpty
    private String password;

    @Column(name = "activo")
    private boolean isEnabled;

    @Column(name = "cuenta_no_expirada")
    private boolean accountNoExpired;

    @Column(name = "cuenta_no_bloqueada")
    private boolean accountNoLocked;

    @Column(name = "credencial_no_expirada")
    private boolean credentialNoExpired;

    @OneToOne(mappedBy = "user")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Empleado empleado;

    @OneToOne(mappedBy = "user")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Cliente cliente;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Role> roles = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
