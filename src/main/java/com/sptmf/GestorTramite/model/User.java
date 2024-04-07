package com.sptmf.GestorTramite.model;

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
}
