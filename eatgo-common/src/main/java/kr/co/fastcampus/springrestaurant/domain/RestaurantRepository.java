package kr.co.fastcampus.springrestaurant.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findAll();

    Optional<Restaurant> findById(Long id);

    List<Restaurant> findAllByAddressContainingAndCategoryId(String region, Long categoryId);

    Restaurant save(Restaurant restaurant);
}
