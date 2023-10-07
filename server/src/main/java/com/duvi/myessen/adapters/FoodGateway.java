package com.duvi.myessen.adapters;

import java.util.Optional;

import com.duvi.myessen.domain.food.Food;


public interface FoodGateway {
    public Optional<Food> getFoodByName(String name);
}
