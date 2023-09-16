package com.duvi.myessen.core.exceptions;

import java.lang.RuntimeException;
import java.lang.Throwable;
public class FoodNotFoundException extends RuntimeException {
    public FoodNotFoundException(String message){
        super(message);
    }
    public FoodNotFoundException(Long id){
        super("Could not find food id: "+id);
    }
    public FoodNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
    
}
