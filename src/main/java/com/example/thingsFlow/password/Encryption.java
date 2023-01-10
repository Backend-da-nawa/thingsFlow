package com.example.thingsFlow;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordControl {
    public String hashingPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
