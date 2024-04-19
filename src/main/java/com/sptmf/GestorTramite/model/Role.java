package com.sptmf.GestorTramite.model;

import com.sptmf.GestorTramite.util.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {
    public Role(RoleEnum name, Set<Permiso> permisos) {
        this.name = name;
        this.permisos = permisos;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre")
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "roles_permisos", joinColumns = @JoinColumn(name = "rol_id"), inverseJoinColumns = @JoinColumn(name = "permiso_id"))
    private Set<Permiso> permisos = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
