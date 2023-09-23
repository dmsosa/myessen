package com.duvi.myessen.core.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import com.duvi.myessen.core.component.FoodModelAssembler;
import com.duvi.myessen.core.entities.*;
import com.duvi.myessen.core.exceptions.*;
@RestController
public class FoodController {

    @Autowired
    private FoodRepository repository;
    private FoodModelAssembler assembler;

    FoodController(FoodRepository repository, FoodModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }
    @CrossOrigin(origins="http://localhost:5173/")
    @GetMapping("/core")
    public CollectionModel<EntityModel<Food>> getAll() {
        List<EntityModel<Food>> foodList = repository.findAll().stream()
        .map(f -> assembler.toModel(f))
        .collect(Collectors.toList());

        return CollectionModel.of(foodList, 
        WebMvcLinkBuilder.linkTo(
            WebMvcLinkBuilder.methodOn(FoodController.class).getAll())
            .withSelfRel());
    }

    @GetMapping("/core/{id}")
    public EntityModel<Food> getOne(@PathVariable Long id) {
        Food f = repository.findById(id).orElseThrow(() -> new FoodNotFoundException(id));
        return assembler.toModel(f);
    }
    @PostMapping("/core")
    public Food addFood(@RequestBody Food f){
        return repository.save(f);
        

    }
    @DeleteMapping("/core/{id}")
    public void deleteFood(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
