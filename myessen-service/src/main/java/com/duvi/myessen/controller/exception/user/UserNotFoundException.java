package com.duvi.myessen.controller.exception.user;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(Long id) {
        super(String.format("User with id \"%s\" was not found", String.valueOf(id)));
    }
    public UserNotFoundException(String login) {
        super(String.format("User with login \"%s\" was not found", login));
    }
}
