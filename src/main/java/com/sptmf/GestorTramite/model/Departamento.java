package com.sptmf.GestorTramite.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "departamentos")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Description", length = 100, nullable = false, unique = true)
    private String detail;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    Set<Empleado> empleados = new HashSet<>();

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    Set<Tramite> tramites = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
