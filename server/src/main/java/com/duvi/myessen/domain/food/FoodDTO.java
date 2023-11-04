package com.duvi.myessen.domain.food;

public record FoodDTO(String name, Long kcal, Long price, String image, String description) {
    public FoodDTO(Food food) {
        this(food.getName(), food.getKcal(), food.getPrice(), food.getImage(), food.getDescription());
    }
}
