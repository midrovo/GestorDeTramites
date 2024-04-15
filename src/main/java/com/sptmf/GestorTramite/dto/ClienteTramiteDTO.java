package com.sptmf.GestorTramite.dto;

import com.sptmf.GestorTramite.model.Tramite;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
public class ClienteTramiteDTO implements Serializable {
    private String name;
    private Set<Tramite> tramites;
}
