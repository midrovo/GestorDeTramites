package com.sptmf.GestorTramite.repository;

import com.sptmf.GestorTramite.model.Permiso;
import com.sptmf.GestorTramite.util.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Long> {
    Optional<Permiso> findByName(String name);
}
