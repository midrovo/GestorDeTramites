package com.sptmf.GestorTramite.repository;

import com.sptmf.GestorTramite.model.Tramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TramiteRepository extends JpaRepository<Tramite, Long> {
}
