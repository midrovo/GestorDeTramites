package com.sptmf.GestorTramite.model.herencia;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    private String name;

    @Column(name = "apellidos", length = 50, nullable = false)
    @NotEmpty
    private String lastname;

    @Column(name = "cedula", length = 10, nullable = false, unique = true)
    @NotEmpty
    private String cedula;

    @Column(name = "email", length = 40)
    private String email;

    @Column(name = "telefono", length = 10)
    private String phone;

    @Column(name = "ciudad", length = 30)
    private String city;

    @Column(name = "direccion", length = 50)
    private String address;
}
