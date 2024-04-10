package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Tramite;

import java.util.List;

public interface TramiteInterface {
    List<Tramite> getAll();
    Tramite getById(Long id);
    Tramite create(Tramite tramite);
    Tramite update(Tramite tramite);
    Tramite delete(Long id);
}
