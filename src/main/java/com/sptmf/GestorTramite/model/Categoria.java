package com.sptmf.GestorTramite.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
