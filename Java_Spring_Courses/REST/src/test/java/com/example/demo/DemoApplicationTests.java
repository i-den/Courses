package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.SecureRandom;

@SpringBootTest
class DemoApplicationTests {

    private SecureRandom RANDOM = new SecureRandom();

    @Test
    void contextLoads() {
        StringBuilder sb = new StringBuilder(5);
        for (int i = 0; i < 5; i++) {
            sb.append((char) (RANDOM.nextInt(122 - 62) + 65));
        }
        System.out.println(sb.toString());
    }

}
