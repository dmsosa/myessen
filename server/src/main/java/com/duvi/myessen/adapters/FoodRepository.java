package com.duvi.myessen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.duvi.myessen.domain.Food;

@Repository
public interface FoodRepository  extends JpaRepository<Food, Long> {
}
