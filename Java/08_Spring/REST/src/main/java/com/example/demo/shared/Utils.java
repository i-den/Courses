package com.example.demo.shared;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class Utils {

    private static final SecureRandom RANDOM = new SecureRandom();

    public String generateId(int len) {
        return generateRandomString(len);
    }

    private String generateRandomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append((char)(RANDOM.nextInt(122 - 62) + 65));
        }
        return sb.toString();
    }
}
