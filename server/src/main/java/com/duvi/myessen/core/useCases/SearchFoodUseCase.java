package com.duvi.myessen.core.useCases;

import com.duvi.myessen.core.entities.Food;

public interface SearchFoodUseCase {
    public Food searchFoodByName(String name);
    public Food searchFoodById(Long id);
    }

