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

public class Exercise {
    @Id
    private String name;
    private Integer quantitySets;
    private Integer quantityReps;
    private Integer resTimeSeconds;    
}
