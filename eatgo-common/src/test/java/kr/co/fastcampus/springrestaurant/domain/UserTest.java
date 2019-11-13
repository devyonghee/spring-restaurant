package kr.co.fastcampus.springrestaurant.domain;

import org.junit.jupiter.api.Test;

import  static org.assertj.core.api.Assertions.*;

class UserTest {
    @Test
    void creation(){
        User user = User.builder()
                .email("tester@example.com")
                .name("테스터")
                .level(100L)
                .build();

        assertThat(user.getName()).isEqualTo("테스터");
        assertThat(user.isAdmin()).isTrue();
    }
}