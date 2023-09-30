package com.duvi.myessen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.duvi.myessen.adapters.FoodRepository;
import com.duvi.myessen.domain.Food;
import com.duvi.myessen.domain.FoodDTO;
import com.duvi.myessen.services.FoodService;
import java.util.List;

@RestController
public class FoodController {
    private FoodRepository repository;
    private FoodService service;
    
    @Autowired
    FoodController(FoodService service, FoodRepository repository) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/food/{name}")
    public FoodDTO getFood(@PathVariable String name)   {
        
    }
}
