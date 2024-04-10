package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.ProcesoInterface;
import com.sptmf.GestorTramite.model.Proceso;
import com.sptmf.GestorTramite.repository.ProcesoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcesoService implements ProcesoInterface {
    @Autowired
    ProcesoRepository procesoRepository;
    @Override
    public List<Proceso> getAll() {
        return procesoRepository.findAll();
    }

    @Override
    public Optional<Proceso> getById(Long id) {
        return procesoRepository.findById(id);
    }

    @Override
    public Proceso create(Proceso proceso) {
        return procesoRepository.save(proceso);
    }

    @Override
    public Proceso update(Proceso proceso) {
        return getById(proceso.getId()).isPresent() ? procesoRepository.save(proceso) : null;
    }

    @Override
    public Proceso delete(Long id) {
        Optional<Proceso> procesoOptional = getById(id);

        if(procesoOptional.isPresent()) {
            Proceso proceso = procesoOptional.get();
            procesoRepository.delete(proceso);
            return proceso;
        }

        return null;
    }
}
