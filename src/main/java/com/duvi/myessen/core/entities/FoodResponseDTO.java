package com.duvi.myessen.core.entities;

public record FoodResponseDTO(Long id, String name, Long kcal) {
    public FoodResponseDTO(Food f){
        this(f.getId(), f.getName(), f.getKcal());
    }
}
