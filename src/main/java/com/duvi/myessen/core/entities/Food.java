package com.duvi.myessen.core.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@Table(name="leben")
@Entity(name="leben")
@EqualsAndHashCode(of = "id")
public class Food {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id ;
    private String name;
    private Long kcal; 
    public Food() {
    }
    public Food(String name, Long kcal) {
        this.name = name;
        this.kcal = kcal;
    }

    @Override
    public String toString() {
        return this.name +" , mit:"+this.kcal;
    }
}
