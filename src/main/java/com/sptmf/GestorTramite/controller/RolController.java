package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.dto.RolDTO;
import com.sptmf.GestorTramite.exception.CustomException;
import com.sptmf.GestorTramite.model.Role;
import com.sptmf.GestorTramite.service.RolService;
import com.sptmf.GestorTramite.util.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping(value = "/mostrar")
    public ResponseEntity<List<Role>> getRols() {
        return new ResponseEntity<List<Role>>(rolService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscar/id/{id}")
    public ResponseEntity<Role> getRolById(@PathVariable Long id) throws CustomException {
        Optional<Role> rolOptional = rolService.getById(id);

        if(rolOptional.isPresent())
            return new ResponseEntity<Role>(rolOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este rol", HttpStatus.NOT_FOUND, "404");

    }

    @GetMapping(value = "/buscar/{name}")
    public ResponseEntity<Role> getRolByName(@PathVariable RoleEnum name) throws CustomException {
        Optional<Role> rolOptional = rolService.getByName(name);

        if(rolOptional.isPresent())
            return new ResponseEntity<Role>(rolOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este rol", HttpStatus.NOT_FOUND, "404");

    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Role> createRol(@RequestBody RolDTO rolDTO) {
        return new ResponseEntity<Role>(rolService.create(rolDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Role> updateRol(@RequestBody Role role) throws CustomException {
        Role roleActualizado = rolService.update(role);

        if(roleActualizado == null)
            throw new CustomException("No se pudo actualizar el rol", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<Role>(roleActualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "eliminar/{id}")
    public ResponseEntity<Role> deleteRol(@PathVariable Long id) throws CustomException {
        Role roleEliminado = rolService.delete(id);

        if(roleEliminado == null)
            throw new CustomException("No se pudo eliminar el rol", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<Role>(roleEliminado, HttpStatus.OK);
    }
}
