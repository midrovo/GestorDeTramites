package com.sptmf.GestorTramite.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre_rol", length = 20, nullable = false, unique = true)
    private String rol;

    @Column(name = "detalle", length = 100, nullable = false)
    private String detail;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rol rol = (Rol) o;
        return id == rol.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
