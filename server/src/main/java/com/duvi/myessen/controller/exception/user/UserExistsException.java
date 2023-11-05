package com.duvi.myessen.controller.exception.user;

public class UserExistsException extends Exception {
    public UserExistsException(Long id) {
        super(String.format("User with id: \"%s\" already exists!", String.valueOf(id)));
    }

    public UserExistsException(String login) {
        super(String.format("User with login: \"%s\" already exists!", login));
    }
}
