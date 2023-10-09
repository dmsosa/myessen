package com.duvi.myessen.domain.food;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Validators
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;



@Table(name = "leben")
@Entity(name = "food")
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "Jedes zutaten muss ein name haben")
    @Pattern(regexp="^[a-zA-Z ]+$", message = "Die name muss ein Ketter sein!")
    @Column(name = "name")
    private String name;


    @NotNull(message = "jede einzige Zutaten ein Geldwert hat!")
    @Positive(message = "Die Zutaten  nicht kostenlos ist, bruder!!")
    @Column(name = "price")
    private Long price;

    @NotNull(message = "jede einzige Zutaten ein Kaloienwert hat!")
    @Positive(message = "es gibt keine Zutaten mit negativen Kalorienwert, bruder!")
    @Column(name = "kcal")
    private Long kcal;


    @URL
    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String description;

    public Food(String name, Long kcal) {
        this.name = name;
        this.kcal = kcal;
    }
    public Food update(Food newFood) {
        return new Food(this.id, newFood.getName(), newFood.getPrice(), newFood.getKcal(), newFood.getImage(), newFood.getDescription());
    }

}
