package com.josealmir.gymmanagementsystem.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.josealmir.gymmanagementsystem.model.workoutplan.Exercise;
import com.josealmir.gymmanagementsystem.requests.ExerciseRequest;

public interface ExerciseService {
    Exercise createExercise(String name, Integer quantitySets, Integer quantityReps, Integer resTimeSeconds);
    List<Exercise> allExercises();
    Optional<Exercise> exerciseById(String id);
    Exercise updateExercise(String id, ExerciseRequest exerciseRequest);
    Exercise cloneExercise(String id);
    void deleteExerciseById(String id);
}
