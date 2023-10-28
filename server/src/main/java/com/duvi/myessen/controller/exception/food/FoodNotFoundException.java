package com.duvi.myessen.controller.exception.food;

public class FoodNotFoundException extends RuntimeException {
    public FoodNotFoundException() {
        super("Food not found!!");
    }

    public FoodNotFoundException(String message) {
        super(message);
    }
}
