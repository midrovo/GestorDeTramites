package com.sptmf.GestorTramite.interfaces.mapper;

import com.sptmf.GestorTramite.dto.DepartamentoDTO;
import com.sptmf.GestorTramite.model.Departamento;

public interface DepartamentoMapperInterface {
    Departamento toDepartamento(DepartamentoDTO departamentoDTO);
}
