package kr.co.fastcampus.springrestaurant.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RestaurantTest {

    @Test
    void creation() {
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();
        assertThat(restaurant.getId()).isEqualTo(1004L);
        assertThat(restaurant.getName()).isEqualTo("Bob zip");
        assertThat(restaurant.getAddress()).isEqualTo("Seoul");
    }

    @Test
    void information() {
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();

        assertThat(restaurant.getId()).isEqualTo(1004L);
        assertThat(restaurant.getInformation()).isEqualTo("Bob zip in Seoul");
    }

}