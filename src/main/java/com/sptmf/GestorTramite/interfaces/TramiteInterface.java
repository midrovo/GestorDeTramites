package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Tramite;

import java.util.List;

public interface TramiteInterface {
    List<Tramite> getTramites();
    Tramite createTramite(Tramite tramite);
}
