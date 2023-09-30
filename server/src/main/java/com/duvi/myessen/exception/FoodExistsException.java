package com.duvi.myessen.exception;


public class FoodExistsException extends RuntimeException {
    public FoodExistsException() {
        super("Food already exists!");
    }

    public FoodExistsException(String message) {
        super(message);
    }
}
