package com.example.thingsFlow.validation;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordValidation {
    public boolean checkHashedPassword(String hashedPassword, String storedPassword) {
        return BCrypt.checkpw(hashedPassword, storedPassword);
    }
}
