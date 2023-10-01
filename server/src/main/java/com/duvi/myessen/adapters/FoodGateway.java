package com.duvi.myessen.adapters;

import java.util.Optional;

import com.duvi.myessen.domain.Food;
import com.duvi.myessen.exception.FoodNotFoundException;


public interface FoodGateway {
    public Optional<Food> getFoodByName(String name) throws FoodNotFoundException;
}
