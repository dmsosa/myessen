package com.duvi.myessen.core.component;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import com.duvi.myessen.core.entities.*;
import com.duvi.myessen.core.controller.FoodController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class FoodModelAssembler implements RepresentationModelAssembler<Food, EntityModel<Food>> {
    @Override 
    public EntityModel<Food> toModel(Food f) {
        return EntityModel.of(f, 
        linkTo(methodOn(FoodController.class).getOne(f.getId())).withSelfRel(),
        linkTo(methodOn(FoodController.class).getAll()).withRel("foods"));
    }
}
