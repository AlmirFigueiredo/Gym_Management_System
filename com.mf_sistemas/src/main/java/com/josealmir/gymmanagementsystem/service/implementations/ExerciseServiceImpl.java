package com.josealmir.gymmanagementsystem.service.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josealmir.gymmanagementsystem.model.workoutplan.Exercise;
import com.josealmir.gymmanagementsystem.repositories.ExerciseRepository;
import com.josealmir.gymmanagementsystem.requests.ExerciseRequest;
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
    @Override
    public List<Exercise> allExercises() {
        return exerciseRepository.findAll();
    }
    @Override
    public Optional<Exercise> exerciseById(String id) {
        return exerciseRepository.findById(id);
    }
    @Override
    public Exercise updateExercise(String id, ExerciseRequest exerciseRequest) {
        Optional<Exercise> optionalExercise = exerciseRepository.findById(id);
        if(optionalExercise.isPresent()) {
            Exercise exercise = optionalExercise.get();
            exercise.setName(exerciseRequest.getName());
            exercise.setQuantityReps(exerciseRequest.getQuantityReps());
            exercise.setQuantitySets(exerciseRequest.getQuantitySets());
            exercise.setResTimeSeconds(exerciseRequest.getResTimeSeconds());
            return exerciseRepository.save(exercise);
        } else {
            throw new NoSuchElementException();
        }
    }
    @Override
    public Exercise cloneExercise(String id) {
        Optional<Exercise> optionalExercise = exerciseRepository.findById(id);
        if(optionalExercise.isPresent()) {
            Exercise original = optionalExercise.get();
            Exercise cloned = original.clone();
            return exerciseRepository.save(cloned);
        } else {
            throw new NoSuchElementException();
        }
    }
    @Override
    public void deleteExerciseById(String id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        if(exercise.isPresent()) {
            exerciseRepository.delete(exercise.get());
        } else {
            throw new NoSuchElementException();
        }
    }
}
