package kr.co.fastcampus.springrestaurant.utils;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {

    private final String secret = "12345678901234567890123456789012";
    private JwtUtil jwtUtil;

    @BeforeEach
    void setUp() {
        jwtUtil = new JwtUtil(secret);
    }

    @Test
    void createToken() {
        String token = jwtUtil.createToken(1004L, "John");
        assertTrue(token.contains("."));
    }

    @Test
    void getClaims() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEwMDQsIm5hbWUiOiJKb2huIn0.8hm6ZOJykSINHxL-rf0yV882fApL3hyQ9-WGlJUyo2A";
        Claims claims = jwtUtil.getClaims(token);
        assertEquals(1004L, claims.get("userId", Long.class));
        assertEquals("John", claims.get("name"));
    }
}