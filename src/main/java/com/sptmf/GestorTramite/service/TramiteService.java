package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.interfaces.TramiteInterface;
import com.sptmf.GestorTramite.model.Tramite;
import com.sptmf.GestorTramite.repository.TramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TramiteService implements TramiteInterface {
    @Autowired
    private TramiteRepository tramiteRepository;

    @Override
    public List<Tramite> getAll() {
        return tramiteRepository.findAll();
    }

    @Override
    public Optional<Tramite> getById(Long id) {
        return tramiteRepository.findById(id);
    }

    @Override
    public Optional<Tramite> getByName(String name) {
        return Optional.empty();
    }

    @Override
    public Tramite create(Tramite tramite) {
        return tramiteRepository.save(tramite);
    }

    @Override
    public Tramite update(Tramite tramite) {
        return getById(tramite.getId()).isPresent() ? tramiteRepository.save(tramite) : null;
    }

    @Override
    public Tramite delete(Long id) {
        Optional<Tramite> tramiteOptional = getById(id);

        if(tramiteOptional.isPresent()) {
            Tramite tramite = tramiteOptional.get();
            tramiteRepository.delete(tramite);
            return tramite;
        }

        return null;
    }
}
