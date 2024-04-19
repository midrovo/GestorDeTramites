package com.sptmf.GestorTramite.repository;

import com.sptmf.GestorTramite.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Optional<Empleado> findByCedula(String cedula);

    @Query(value = "SELECT * FROM empleados WHERE usuario_id = (SELECT id FROM usuarios WHERE nombre_usuario = :username)", nativeQuery = true)
    Optional<Empleado> findByUsername(@Param("username") String username);
}
