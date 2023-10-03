package com.duvi.myessen.services;

import com.duvi.myessen.domain.Food;
import com.duvi.myessen.exception.food.FoodExistsException;
import com.duvi.myessen.exception.food.FoodNotFoundException;

import java.util.List;

public interface FoodService {
    List<Food> getFoods();
    Food getFood(Long id) throws FoodNotFoundException;
    Food addFood(String name, Long kcal) throws FoodExistsException;
    Food getFoodByName(String name) throws FoodNotFoundException;
}
