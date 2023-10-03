package com.duvi.myessen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.duvi.myessen.domain.Food;
import com.duvi.myessen.domain.transfer.FoodDTO;
import com.duvi.myessen.services.FoodService;



@RestController
public class FoodController {
    private FoodService service;
    
    @Autowired
    FoodController(FoodService service) {
        this.service = service;
    }

    @GetMapping("/food/{name}")
    public FoodDTO getFood(@PathVariable String name)   {
        System.out.println(name);
        Food food = service.getFoodByName(name);
        FoodDTO foodTransferObject = new FoodDTO(food);
        System.out.print(food.toString());
        return foodTransferObject;
    }

    @GetMapping("/")
    public void NotFound() {
        System.out.print("Not Found");
    }
}
