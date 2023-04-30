package com.josealmir.gymmanagementsystem.service.interfaces;

import com.josealmir.gymmanagementsystem.model.workoutplan.Exercise;

public interface ExerciseService {
    Exercise createExercise(String name, Integer quantitySets, Integer quantityReps, Integer resTimeSeconds);

}
