package com.sptmf.GestorTramite.model.herencia;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres", length = 50, nullable = false)
    private String name;

    @Column(name = "apellidos", length = 50, nullable = false)
    private String lastname;
}
