package kr.co.fastcampus.springrestaurant.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findAllByRestaurantId(Long restaurantId);
}
