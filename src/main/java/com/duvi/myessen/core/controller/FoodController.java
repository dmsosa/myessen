package com.duvi.myessen.core.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.duvi.myessen.core.entities.*;
import com.duvi.myessen.core.exceptions.*;
@RestController
public class FoodController {
    @Autowired
    private FoodRepository repository;
    
    @GetMapping("/core")
    public List<Food> getAll() {
        List<Food> foodList = repository.findAll();
        return foodList;
    }

    @GetMapping("/core/{id}")
    public Food getOne(@PathVariable Long id) {
        Food f = repository.findById(id).orElseThrow(() -> new FoodNotFoundException(id));
        return f;
    }
    
}
