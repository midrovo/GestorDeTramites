package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Departamento;

import java.util.List;

public interface DepartamentoInterface {
    List<Departamento> getDepartaments();
    Departamento createDepartament(Departamento departamento);
}
