package com.duvi.myessen.services;

import com.duvi.myessen.domain.Food;
import com.duvi.myessen.exception.food.FoodExistsException;
import com.duvi.myessen.exception.food.FoodNotFoundException;

import java.util.List;

public interface FoodService {
    List<Food> getFoods();
    public Food getFood(Long id) throws FoodNotFoundException;
    public Food addFood(String name, Long price, Long kcal, String image, String description) throws FoodExistsException;
    public Food getFoodByName(String name) throws FoodNotFoundException;
    public Food updateFood(Long oldFoodId, Food newFood);
    public void deleteFood(Long foodId);
}
