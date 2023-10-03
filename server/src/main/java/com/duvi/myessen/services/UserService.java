package com.duvi.myessen.services;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import com.duvi.myessen.domain.User;
import com.duvi.myessen.exception.user.UserNotFoundException;

public interface UserService {
    public CollectionModel<EntityModel<User>> findAllUsers();
    public EntityModel<User> findUserById(Long id) throws UserNotFoundException;
}