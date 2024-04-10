package com.sptmf.GestorTramite.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sptmf.GestorTramite.model.herencia.Persona;
import jakarta.persistence.*;
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
    private String username;

    @Column(name = "clave", length = 15, nullable = false)
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Empleado empleado;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rol_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Rol rol;
}
