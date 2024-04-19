package com.sptmf.GestorTramite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "permisos")
@NoArgsConstructor
@AllArgsConstructor
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", unique = true, nullable = false, updatable = false)
    private String name;

    public Permiso(String name) {
        this.name = name;
    }
}
