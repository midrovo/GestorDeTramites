package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.ProcesoInterface;
import com.sptmf.GestorTramite.model.Proceso;
import com.sptmf.GestorTramite.repository.ProcesoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcesoService implements ProcesoInterface {
    @Autowired
    ProcesoRepository procesoRepository;
    @Override
    public List<Proceso> getProcesses() {
        return procesoRepository.findAll();
    }

    @Override
    public Proceso createProcess(Proceso proceso) {
        return procesoRepository.save(proceso);
    }
}
