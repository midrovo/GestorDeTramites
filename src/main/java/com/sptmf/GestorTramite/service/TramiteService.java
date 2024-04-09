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
    public List<Tramite> getTramites() {
        return tramiteRepository.findAll();
    }

    @Override
    public Tramite createTramite(Tramite tramite) {
        return tramiteRepository.save(tramite);
    }
}
