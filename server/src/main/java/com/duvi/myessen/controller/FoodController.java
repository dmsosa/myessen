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

import com.duvi.myessen.controller.exception.food.FoodExistsException;
import com.duvi.myessen.controller.exception.food.FoodNotFoundException;
import com.duvi.myessen.domain.food.Food;
import com.duvi.myessen.domain.food.FoodDTO;
import com.duvi.myessen.services.FoodService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/menu/items")
public class FoodController {

    @Autowired
    private FoodService service;
    
    


    // @GetMapping("/food/{name}")
    // public FoodDTO getFood(@PathVariable String name)   {
    //     System.out.println(name);
    //     Food food = service.getFoodByName(name);
    //     FoodDTO foodTransferObject = new FoodDTO(food);
    //     System.out.print(food.toString());
    //     return foodTransferObject;
    // }

    @GetMapping
    public List<Food> getAll() {
        System.out.print("yoAAAA###");
        return this.service.getFoods();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFood(@PathVariable Long id) throws FoodNotFoundException {
        try {
            Food food = this.service.getFood(id);
            return new ResponseEntity<>(food, HttpStatus.OK);
        } catch (FoodNotFoundException ex) {
            throw ex;
        }
    }
    @PostMapping
    public ResponseEntity<Food> createFood(@Valid @RequestBody FoodDTO food) throws FoodExistsException {
        try {
            Food newFood = this.service.addFood(food.name(), food.kcal(), food.price(), food.image(), food.description());
            return new ResponseEntity<>(newFood, HttpStatus.OK);
        } catch (FoodExistsException ex) {
            throw ex;
        } 

    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id, @Valid@RequestBody FoodDTO food) {
        Food newFood = this.service.updateFood(id, food);
        return new ResponseEntity<>(newFood, HttpStatus.OK);      
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable Long id) throws FoodNotFoundException {
        try {
            this.service.deleteFood(id);
            return new ResponseEntity<>(String.format("Food with ID: %s successfully deleted!", String.valueOf(id)),HttpStatus.ACCEPTED);
        } catch (FoodNotFoundException ex) {
            throw ex;
        }
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

