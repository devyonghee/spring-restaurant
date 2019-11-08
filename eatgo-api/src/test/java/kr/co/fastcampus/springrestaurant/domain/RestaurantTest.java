package kr.co.fastcampus.springrestaurant.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RestaurantTest {

    @Test
    void creation() {
        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
        assertThat(restaurant.getId()).isEqualTo(1004L);
        assertThat(restaurant.getName()).isEqualTo("Bob zip");
        assertThat(restaurant.getAddress()).isEqualTo("Seoul");
    }

    @Test
    void information() {
        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
        assertThat(restaurant.getId()).isEqualTo(1004L);
        assertThat(restaurant.getInformation()).isEqualTo("Bob zip in Seoul");
    }

}