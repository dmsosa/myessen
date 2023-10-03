package com.duvi.myessen.adapters;

import java.util.Optional;

import com.duvi.myessen.domain.Food;


public interface FoodGateway {
    public Optional<Food> getFoodByName(String name);
}
