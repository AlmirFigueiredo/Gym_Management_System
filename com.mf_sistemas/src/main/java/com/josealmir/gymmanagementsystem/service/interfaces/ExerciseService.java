package com.josealmir.gymmanagementsystem.service.interfaces;

import java.util.List;

import com.josealmir.gymmanagementsystem.model.workoutplan.Exercise;

public interface ExerciseService {
    Exercise createExercise(String name, Integer quantitySets, Integer quantityReps, Integer resTimeSeconds);
    List<Exercise> allExercises();
}
