package com.duvi.myessen.controller;



import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.duvi.myessen.domain.User;
import com.duvi.myessen.services.impl.UserServiceImpl;



@RestController
public class UserController {

    UserServiceImpl service;

    public UserController(UserServiceImpl service){ 
        this.service = service;
    }

    @GetMapping("/api/users")
    public CollectionModel<EntityModel<User>> getAll() {
        return service.findAllUsers();
    } 
    @GetMapping("/api/user/{id}")
    public EntityModel<User> getOne(@PathVariable Long id) {
        return service.findUserById(id);
    } 
}
