package com.example.api.controller;

import com.example.dto.UserDTO;
import com.example.repository.UserRepository;
import com.example.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/users",
    produces="application/json")
@CrossOrigin(origins="*")
public class UserController {
    private UserRepository userRepo;
    private UserService userService;

    public UserController(UserRepository userRepository) {
        this.userRepo = userRepository;
    }
    @PostMapping(" ")
    public void postUser(@RequestBody UserDTO userDTO) {
        try{
            userService.createUser(userDTO);
        }
        catch {

        }
    }
}
