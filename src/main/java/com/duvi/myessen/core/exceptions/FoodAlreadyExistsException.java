package com.duvi.myessen.core.exceptions;

public class FoodAlreadyExistsException extends RuntimeException {
    public FoodAlreadyExistsException(String message){
        super(message);
    }

    public FoodAlreadyExistsException(Long id){
        super("That 'essen' ${id} is alreay in our database!");
    }
}
