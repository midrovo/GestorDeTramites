package com.sptmf.GestorTramite.model.herencia;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sptmf.GestorTramite.model.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public class Persona {
    @Column(name = "nombres", length = 50, nullable = false)
    private String name;

    @Column(name = "apellidos", length = 50, nullable = false)
    private String lastname;

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
}
