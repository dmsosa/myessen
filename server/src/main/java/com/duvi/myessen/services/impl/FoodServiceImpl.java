package com.duvi.myessen.services.impl;

import com.duvi.myessen.services.FoodService;
import com.duvi.myessen.adapters.FoodRepository;
import com.duvi.myessen.domain.Food;
import com.duvi.myessen.exception.FoodExistsException;
import com.duvi.myessen.exception.FoodNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;




public class FoodServiceImpl implements FoodService {

    private FoodRepository repository;

    @Autowired
    public FoodServiceImpl(FoodRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Food> getFoods() {
        return repository.findAll(); 
    }    

    @Override
    public Food getFood(Long id) throws FoodNotFoundException {
        Optional<Food> food = repository.findById(id);

        if (food.isPresent()) {
            return food.get();
        } else {
            throw new FoodNotFoundException("Food with id="+id+" not found!!");
        }
    }

    @Override
    public Food addFood(String name, Long kcal) throws FoodExistsException {
        if (repository.existsByName(name)) {
            throw new FoodExistsException(name + "already stored!!");
        }
        else {
            Food b = new Food();
        b.setName(name);
        b.setKcal(kcal);
        return b; }
    }

    @Override
    public Food getFoodByName(String name) throws FoodNotFoundException {
            
    }
}
