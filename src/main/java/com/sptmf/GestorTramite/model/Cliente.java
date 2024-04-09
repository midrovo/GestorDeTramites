package com.sptmf.GestorTramite.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sptmf.GestorTramite.model.herencia.Persona;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(name = "clientes")
public class Cliente extends Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cedula", length = 10, nullable = false)
    private String cedula;

    @Column(name = "email", length = 40, nullable = false)
    private String email;

    @Column(name = "telefono", length = 10, nullable = false)
    private String phone;

    @Column(name = "ciudad", length = 30, nullable = false)
    private String city;

    @Column(name = "direccion", length = 50, nullable = false)
    private String address;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    Set<Tramite> tramites = new HashSet<>();
}
