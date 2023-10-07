package com.duvi.myessen.services.impl;

import com.duvi.myessen.services.FoodService;
import com.duvi.myessen.adapters.FoodGateway;
import com.duvi.myessen.adapters.FoodRepository;
import com.duvi.myessen.domain.food.Food;
import com.duvi.myessen.exception.food.FoodExistsException;
import com.duvi.myessen.exception.food.FoodNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class FoodServiceImpl implements FoodService {
    private FoodGateway gateway;
    private FoodRepository repository;

    @Autowired
    public FoodServiceImpl(FoodRepository repository, FoodGateway gateway) {
        this.repository = repository;
        this.gateway = gateway;
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
    public Food addFood(String name, Long price, Long kcal, String image, String description) throws FoodExistsException {
        if (repository.existsByName(name)) {
            throw new FoodExistsException(name + "already stored!!");
        }
        else {
            Food b = new Food();
            b.setName(name);
            b.setPrice(price);
            b.setKcal(kcal);
            b.setImage(image);
            b.setDescription(description);
            this.repository.save(b);
            return b; 
        }
    }

    @Override
    public Food getFoodByName(String name) throws FoodNotFoundException {
            Optional<Food> food = this.gateway.getFoodByName(name);
            if (food.isPresent()) {
                return food.get();
            } else {
                throw new FoodNotFoundException(name + " was not found!!");
            }
    }

    @Override
    public Food updateFood(Long oldFoodId, Food newFood) {
        Optional<Food> oldFood = this.repository.findById(oldFoodId);
        if (oldFood.isPresent()) {
            Food updated = oldFood.get().update(newFood);
            repository.save(updated);
            return updated;
        } else {
            this.repository.save(newFood);
            return newFood;
        }
        
    }

    @Override
    public void deleteFood(Long foodId){
        this.repository.deleteById(foodId);
    }
}
