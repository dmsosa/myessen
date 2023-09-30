package com.duvi.myessen.domain;

public record FoodDTO(Long id, String name, Long kcal) {
    public FoodDTO(Food food) {
        this(food.getId(), food.getName(), food.getKcal());
    }
}
