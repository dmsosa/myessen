package com.duvi.myessen.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.duvi.myessen.domain.food.Food;

import jakarta.persistence.EntityManager;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
public class FoodRepositoryTest {
    
    @Autowired
    FoodRepository foodRepository;

    @Autowired
    EntityManager entityManager;


    @Test
    void afterSaveFoodisNotEmpty() {
        Food food = new Food("Erdnuss",(long) 439, (long) 10);
        entityManager.persist(food);
        foodRepository.save(food);
        assertThat(foodRepository.findAll().isEmpty()).isFalse();
    }
}
