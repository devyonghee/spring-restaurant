package kr.co.fastcampus.springrestaurant.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RegionTest {
    @Test
    void creation() {
        Region region = Region.builder().name("서울").build();

        assertThat(region.getName()).isEqualTo("서울");
    }
}