package com.sptmf.GestorTramite.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tramites")
public class Tramite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", length = 200, nullable = true)
    private String detail;

    @Column(name = "certificado", length = 100, nullable = false)
    private String certificate;

    @Column(name = "no_notificacion", nullable = true)
    private String notificacion;

    @Column(name = "oficio", length = 100, nullable = true)
    private String oficio;

    @Column(name = "registro_contrato", length = 30, nullable = false)
    private String registroContrato;

    @Column(name = "comentario", length = 100, nullable = true)
    private String comentario;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDateTime dateTimeIngreso;

    @Column(name = "fecha_salida", nullable = false)
    private LocalDateTime dateTimeSalida;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "departamento_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Departamento departamento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "oficinista_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Empleado oficinista;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "analista_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Empleado analista;

}
