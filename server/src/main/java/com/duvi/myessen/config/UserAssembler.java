package com.duvi.myessen.config;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import com.duvi.myessen.controller.UserController;
import com.duvi.myessen.domain.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;


@Component
public class UserAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {
    @Override
    public EntityModel<User> toModel(User user) {

        return EntityModel.of(user, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getOne(user.getId())).withSelfRel(),
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getAll()).withRel("users"));
    }   
}
