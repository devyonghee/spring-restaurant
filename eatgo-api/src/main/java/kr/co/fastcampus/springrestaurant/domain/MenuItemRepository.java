package kr.co.fastcampus.springrestaurant.domain;

import java.util.List;

public interface MenuItemRepository {
    List<MenuItem> findAllByRestaurantById(Long restaurantId);
}
