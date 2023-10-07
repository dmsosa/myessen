package com.duvi.myessen.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duvi.myessen.domain.food.Food;
import com.duvi.myessen.domain.transfer.FoodDTO;
import com.duvi.myessen.services.FoodService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "https://dashboard.whatabyte.app")
@RestController
@RequestMapping("api/menu/items")
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

    @GetMapping
    public List<Food> getAll() {
        return this.service.getFoods();
    }

    @GetMapping("/{id}")
    public Food getFood(@PathVariable Long id) {
        return this.service.getFood(id);
    }
    @PostMapping
    public ResponseEntity<Food> createFood(@Valid@RequestBody Food food) {
        Food newFood = this.service.addFood(food.getName(), food.getPrice(), food.getKcal(), food.getImage(), food.getDescription());
        ResponseEntity<Food> response = new ResponseEntity<>(newFood, HttpStatus.OK);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id, @Valid@RequestBody Food food) {
        this.service.updateFood(id, food);
        ResponseEntity<Food> response = new ResponseEntity<>(this.service.getFood(id), HttpStatus.OK);
        return response;
    }
    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        this.service.deleteFood(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException exception) {
        List<ObjectError> errors = exception.getBindingResult().getAllErrors();
        Map<String,String> map = new HashMap<>(errors.size());
        errors.forEach((err) -> {
            String key = ((FieldError) err).getField();
            String value = err.getDefaultMessage();
            map.put(key, value);
        });
        return ResponseEntity.badRequest().body(map);
    }

    }

