package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.exception.CustomException;
import com.sptmf.GestorTramite.model.User;
import com.sptmf.GestorTramite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/mostrar")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<List<User>>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscar/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws CustomException {
        Optional<User> userOptional = userService.getById(id);

        if(userOptional.isPresent())
            return new ResponseEntity<User>(userOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este usuario", HttpStatus.NOT_FOUND, "404");

    }

    @GetMapping(value = "/buscar/{name}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) throws CustomException {
        Optional<User> userOptional = userService.getByUsername(username);

        if(userOptional.isPresent())
            return new ResponseEntity<User>(userOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este usuario", HttpStatus.NOT_FOUND, "404");

    }

    @PostMapping(value = "/crear")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.create(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<User> updateUser(@RequestBody User user) throws CustomException {
        User usuarioActualizado = userService.update(user);

        if(usuarioActualizado == null)
            throw new CustomException("No se pudo actualizar el usuario", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<User>(usuarioActualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "eliminar/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) throws CustomException {
        User usuarioEliminado = userService.delete(id);

        if(usuarioEliminado == null)
            throw new CustomException("No se pudo eliminar el usuario", HttpStatus.NOT_FOUND, "404");

        return new ResponseEntity<User>(usuarioEliminado, HttpStatus.OK);
    }
}
