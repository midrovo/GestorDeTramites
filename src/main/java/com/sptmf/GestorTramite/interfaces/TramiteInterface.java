package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Tramite;

import java.util.List;
import java.util.Optional;

public interface TramiteInterface {
    List<Tramite> getAll();
    Optional<Tramite> getById(Long id);
    Tramite create(Tramite tramite);
    Tramite update(Tramite tramite);
    Tramite delete(Long id);
}
