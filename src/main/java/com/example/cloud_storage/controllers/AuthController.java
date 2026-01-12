package com.example.cloud_storage.controllers;

import com.example.cloud_storage.models.User;
import com.example.cloud_storage.models.UserLoginRequest;
import com.example.cloud_storage.models.UserRegisterRequest;
import com.example.cloud_storage.services.JwtService;
import com.example.cloud_storage.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterRequest request) {
        try {
            User user = userService.registerUser(request.getName(), request.getEmail(), request.getPassword());
            return ResponseEntity.ok(Map.of(
                    "message", "User registered successfully",
                    "id", user.getId(),
                    "email", user.getEmail()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest request) {
        try {
            User user = userService.loginUser(request.getEmail(), request.getPassword());
            String token = jwtService.generateToken(user.getEmail());

            return ResponseEntity.ok(Map.of(
                    "message", "Login successful",
                    "token", token
            ));
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error: " + e.getMessage());
        }
    }
}
