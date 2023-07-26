package com.example.backend.controllers;

import com.example.backend.entities.Utente;
import com.example.backend.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")         // Serve perché frontend angular è su lo:4200 e Spring su lo:8080
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<Utente> getUsers(){
        return (List<Utente>) userRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody Utente utente){
        userRepository.save(utente);
    }

}
