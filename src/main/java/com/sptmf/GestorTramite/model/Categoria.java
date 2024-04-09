package com.sptmf.GestorTramite.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Description", length = 100, nullable = false)
    private String detail;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    Set<Proceso> procesos = new HashSet<>();
}
