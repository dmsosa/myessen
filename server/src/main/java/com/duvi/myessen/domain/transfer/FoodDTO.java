package com.duvi.myessen.domain.transfer;

import com.duvi.myessen.domain.Food;

public record FoodDTO(Long id, String name, Long kcal) {
    public FoodDTO(Food food) {
        this(food.getId(), food.getName(), food.getKcal());
    }
}
