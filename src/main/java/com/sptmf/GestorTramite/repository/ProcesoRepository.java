package com.sptmf.GestorTramite.repository;

import com.sptmf.GestorTramite.model.Proceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProcesoRepository extends JpaRepository<Proceso, Long> {
    Optional<Proceso> findByDetail(String name);
}
