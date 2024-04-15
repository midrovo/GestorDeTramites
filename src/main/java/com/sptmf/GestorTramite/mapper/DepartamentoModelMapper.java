package com.sptmf.GestorTramite.mapper;

import com.sptmf.GestorTramite.dto.DepartamentoDTO;
import com.sptmf.GestorTramite.interfaces.mapper.DepartamentoMapperInterface;
import com.sptmf.GestorTramite.model.Departamento;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoModelMapper implements DepartamentoMapperInterface {
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public Departamento toDepartamento(DepartamentoDTO departamentoDTO) {
        return mapper.map(departamentoDTO, Departamento.class);
    }
}
