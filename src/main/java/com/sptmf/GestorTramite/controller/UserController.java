package com.sptmf.GestorTramite.controller;

import com.sptmf.GestorTramite.model.User;
import com.sptmf.GestorTramite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/mostrar-usuarios")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping(value = "/crear-usuario")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }
}
