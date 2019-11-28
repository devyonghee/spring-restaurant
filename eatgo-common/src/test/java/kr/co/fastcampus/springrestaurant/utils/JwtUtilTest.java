package kr.co.fastcampus.springrestaurant.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {
    @Test
    void createToken() {
        String secret = "12345678901234567890123456789012";
        JwtUtil jwtUtil= new JwtUtil(secret);
        String token= jwtUtil.createToken(1004L, "John");
        assertTrue(token.contains("."));
    }
}