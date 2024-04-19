package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.dto.UserDTO;
import com.sptmf.GestorTramite.dto.UserRolDTO;
import com.sptmf.GestorTramite.exception.CustomException;
import com.sptmf.GestorTramite.model.User;
import com.sptmf.GestorTramite.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/mostrar")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<List<User>>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/login-validate/{username}/{password}")
    public ResponseEntity<User> getLoginValidate(
            @PathVariable(value = "username") String username,
            @PathVariable(value = "password") String password) throws CustomException {
        Optional<User> userOptional = userService.getByUsernameAndPassword(username, password);

        if(userOptional.isPresent())
            return new ResponseEntity<User>(userOptional.get(), HttpStatus.OK);

        throw new CustomException("No existe este usuario", HttpStatus.NOT_FOUND, "404");
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
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO, BindingResult result) throws CustomException {
        if(result.hasFieldErrors()) {
            throw new CustomException("Error de campos", validation(result), HttpStatus.BAD_REQUEST, "400");
        }

        return new ResponseEntity<User>(userService.create(userDTO), HttpStatus.CREATED);
    }

    @PostMapping(value = "/user-auth")
    public ResponseEntity<UserRolDTO> clientLogin(@Valid @RequestBody UserDTO userDTO, BindingResult result) throws CustomException {
        UserRolDTO userRolDTO = userService.userAuth(userDTO.getUsername(), userDTO.getPassword());

        if(userRolDTO == null) {
            throw new CustomException("Credenciales incorrectas, intente nuevamente.", HttpStatus.NOT_FOUND, "404");
        }

        return new ResponseEntity<UserRolDTO>(userRolDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user, BindingResult result) throws CustomException {
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

    private Map<String, String> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });

        return errors;
    }
}
