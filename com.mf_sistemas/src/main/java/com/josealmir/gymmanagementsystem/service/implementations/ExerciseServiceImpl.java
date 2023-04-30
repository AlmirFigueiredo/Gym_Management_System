package com.josealmir.gymmanagementsystem.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josealmir.gymmanagementsystem.model.workoutplan.Exercise;
import com.josealmir.gymmanagementsystem.repositories.ExerciseRepository;
import com.josealmir.gymmanagementsystem.service.interfaces.ExerciseService;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public Exercise createExercise(String name, Integer quantitySets, Integer quantityReps, Integer resTimeSeconds) {
        Exercise exercise = exerciseRepository.insert(new Exercise(name, quantitySets, quantityReps, resTimeSeconds));
        return exercise;
    }
}
