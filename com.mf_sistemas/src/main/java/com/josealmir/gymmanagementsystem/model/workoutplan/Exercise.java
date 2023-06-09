package com.josealmir.gymmanagementsystem.model.workoutplan;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "exercises")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Exercise implements Cloneable {
    @Id
    private String id;
    private String name;
    private Integer quantitySets;
    private Integer quantityReps;
    private Integer resTimeSeconds;    
    public Exercise(String name, Integer quantitySets, Integer quantityReps, Integer resTimeSeconds) {
        this.name = name;
        this.quantityReps = quantityReps;
        this.quantitySets = quantitySets;
        this.resTimeSeconds = resTimeSeconds;
    }
    @Override
    public Exercise clone() {
        try {
            return (Exercise) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Modificacao falhou");
        }
    }
}
