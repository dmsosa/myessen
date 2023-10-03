package com.duvi.myessen.services.impl;

import java.util.stream.Collectors;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import com.duvi.myessen.adapters.UserRepository;
import com.duvi.myessen.config.UserAssembler;
import com.duvi.myessen.controller.UserController;
import com.duvi.myessen.domain.User;
import com.duvi.myessen.exception.user.UserNotFoundException;
import com.duvi.myessen.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository repository;
    private final UserAssembler assembler;

    public UserServiceImpl(UserRepository repository, UserAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @Override
    public CollectionModel<EntityModel<User>> findAllUsers() {
        List<EntityModel<User>> userList = repository.findAll().stream().map((user) -> assembler.toModel(user)).collect(Collectors.toList());
        return CollectionModel.of
        (userList, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getAll()).withSelfRel());
    }

    @Override
    public EntityModel<User> findUserById(Long id) throws UserNotFoundException {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        EntityModel<User> userModel = assembler.toModel(user);
        return userModel;
    }
}