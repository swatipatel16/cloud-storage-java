package com.example.cloud_storage.models;
import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
