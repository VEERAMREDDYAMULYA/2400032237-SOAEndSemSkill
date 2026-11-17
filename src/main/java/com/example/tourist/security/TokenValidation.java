package com.example.tourist.security;

import org.springframework.stereotype.Component;

@Component
public class TokenValidation {
    private static final String VALID_TOKEN = "my-secret-token";

    public boolean validateToken(String token) {
        return VALID_TOKEN.equals(token);
    }
}
