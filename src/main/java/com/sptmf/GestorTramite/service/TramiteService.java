package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.TramiteInterface;
import com.sptmf.GestorTramite.model.Tramite;
import com.sptmf.GestorTramite.repository.TramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TramiteService implements TramiteInterface {
    @Autowired
    TramiteRepository tramiteRepository;

    @Override
    public List<Tramite> getAll() {
        return tramiteRepository.findAll();
    }

    @Override
    public Tramite getById(Long id) {
        return null;
    }

    @Override
    public Tramite create(Tramite tramite) {
        return tramiteRepository.save(tramite);
    }

    @Override
    public Tramite update(Tramite tramite) {
        return null;
    }

    @Override
    public Tramite delete(Long id) {
        return null;
    }
}
