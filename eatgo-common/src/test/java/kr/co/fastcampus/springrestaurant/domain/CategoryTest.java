package kr.co.fastcampus.springrestaurant.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CategoryTest {
    @Test
    void creation() {
        Category category = Category.builder().name("Korean Food").build();
        assertThat(category.getName()).isEqualTo("Korean Food");
    }
}