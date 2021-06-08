package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(security = @SecurityRequirement(name = "basicAuth"))
    public User saveUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(security = @SecurityRequirement(name = "basicAuth"))
    public List<User> getAll() {
        return userRepo.findAll();
    }
}
