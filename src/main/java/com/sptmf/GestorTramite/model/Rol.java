package com.sptmf.GestorTramite.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "rol", length = 20, nullable = false)
    private String rol;

    @Column(name = "Description", length = 100, nullable = false)
    private String detail;


}
