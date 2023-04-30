package com.josealmir.gymmanagementsystem.requests;

import lombok.Data;

@Data
public class ExerciseRequest {
    private String name;
    private Integer quantitySets;
    private Integer quantityReps;
    private Integer resTimeSeconds;
}
