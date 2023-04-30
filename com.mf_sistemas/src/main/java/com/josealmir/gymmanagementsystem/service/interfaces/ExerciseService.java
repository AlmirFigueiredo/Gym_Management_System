package com.josealmir.gymmanagementsystem.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.josealmir.gymmanagementsystem.model.workoutplan.Exercise;

public interface ExerciseService {
    Exercise createExercise(String name, Integer quantitySets, Integer quantityReps, Integer resTimeSeconds);
    List<Exercise> allExercises();
    Optional<Exercise> exerciseByName(String id);
    void deleteExerciseByName(String id);
}
