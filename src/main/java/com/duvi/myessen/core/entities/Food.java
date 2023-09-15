package com.duvi.myessen.core.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Food {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id ;
    private String name;
    private Long kcal; 
    Food(String name, Long kcal) {
        this.name = name;
        this.kcal = kcal;
    }

    @Override
    public String toString() {
        return this.name +" , mit:"+this.kcal;
    }
}
