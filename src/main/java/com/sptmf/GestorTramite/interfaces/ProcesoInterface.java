package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Proceso;

import java.util.List;

public interface ProcesoInterface {
    List<Proceso> getProcesses();
    Proceso createProcess(Proceso proceso);
}
