package com.sptmf.GestorTramite.repository;

import com.sptmf.GestorTramite.model.Role;
import com.sptmf.GestorTramite.util.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}
