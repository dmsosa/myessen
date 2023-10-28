package com.duvi.myessen.controller.exception.food;


public class FoodExistsException extends RuntimeException {
    public FoodExistsException() {
        super("Food already exists!");
    }

    public FoodExistsException(String message) {
        super(message);
    }
}
