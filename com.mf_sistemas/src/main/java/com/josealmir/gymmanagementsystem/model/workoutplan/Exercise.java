package com.josealmir.gymmanagementsystem.model.workoutplan;

public class Exercise {
    private String name;
    private Integer quantitySets;
    private Integer quantityReps;
    private Integer resTimeSeconds;

    public Exercise() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantitySets() {
        return quantitySets;
    }

    public void setQuantitySets(Integer quantitySets) {
        this.quantitySets = quantitySets;
    }

    public Integer getQuantityReps() {
        return quantityReps;
    }

    public void setQuantityReps(Integer quantityReps) {
        this.quantityReps = quantityReps;
    }

    public Integer getResTimeSeconds() {
        return resTimeSeconds;
    }

    public void setResTimeSeconds(Integer resTimeSeconds) {
        this.resTimeSeconds = resTimeSeconds;
    }

    
}
