package com.sptmf.GestorTramite.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres", length = 50, nullable = false)
    private String name;

    @Column(name = "apellidos", length = 50, nullable = false)
    private String lastname;
}
