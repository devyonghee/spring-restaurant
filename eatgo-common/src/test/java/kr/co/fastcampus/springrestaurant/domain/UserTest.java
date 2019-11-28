package kr.co.fastcampus.springrestaurant.domain;

import org.junit.jupiter.api.Test;

import  static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void creation(){
        User user = User.builder()
                .email("tester@example.com")
                .name("테스터")
                .level(100L)
                .build();

        assertEquals("테스터", user.getName());
        assertTrue(user.isAdmin());
        assertTrue(user.isActive());

        user.deactivate();

        assertFalse(user.isActive());
    }
}