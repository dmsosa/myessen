package com.duvi.myessen.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "leben")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
public class Food {

    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "kcal")
    private Long kcal;

    public Food(String name, Long kcal) {
        this.name = name;
        this.kcal = kcal;
    }

}
