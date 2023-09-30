package com.duvi.myessen.adapters;

import com.duvi.myessen.domain.Food;
import com.duvi.myessen.exception.FoodNotFoundException;

public interface FoodGateway {
    public Food searchFood(String name) throws FoodNotFoundException;
}
