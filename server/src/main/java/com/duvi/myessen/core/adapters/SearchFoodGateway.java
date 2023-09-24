package com.duvi.myessen.core.adapters;

import com.duvi.myessen.core.entities.Food;

public interface SearchFoodGateway {
    public Food searchFoodByName(String name);
}
