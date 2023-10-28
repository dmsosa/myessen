package com.duvi.myessen.controller.exception.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Food not found!!");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
    public UserNotFoundException(Long id) {
        super("User with id: "+id+"was not found!");
    }
}
