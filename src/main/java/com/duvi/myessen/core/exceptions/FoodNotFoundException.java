package com.duvi.myessen.core.exceptions;

import java.lang.RuntimeException;
import java.lang.Throwable;
public class FoodNotFoundException extends RuntimeException {
    public FoodNotFoundException(String name){
        super("Could not find food: "+name);
    }
    public FoodNotFoundException(Long id){
        super("Could not find food id: "+id);
    }
    public FoodNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
    
}
