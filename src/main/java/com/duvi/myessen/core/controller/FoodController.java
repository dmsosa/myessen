package com.duvi.myessen.core.controller;

import java.util.List;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.duvi.myessen.core.entities.*;

@RestController
public class FoodController {
    private final FoodRepository repository;
    
    @GetMapping("/core")
    List<Food> getAll() {
        List<Food> foodList = repository.findAll();
        return foodList;
    }
}
