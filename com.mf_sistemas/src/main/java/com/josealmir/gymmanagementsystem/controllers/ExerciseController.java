package com.josealmir.gymmanagementsystem.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josealmir.gymmanagementsystem.model.workoutplan.Exercise;
import com.josealmir.gymmanagementsystem.requests.ExerciseRequest;
import com.josealmir.gymmanagementsystem.service.interfaces.ExerciseService;

@RestController
@RequestMapping("/Exercises")
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    @GetMapping()
    public ResponseEntity<List<Exercise>> getAllExercises() {
        return new ResponseEntity<List<Exercise>>(exerciseService.allExercises(), HttpStatus.OK);
    }

    @PostMapping()
    public Exercise createExercise(@RequestBody ExerciseRequest exerciseRequest) {
        String name = exerciseRequest.getName();
        Integer quantitySets = exerciseRequest.getQuantitySets();
        Integer quantityReps = exerciseRequest.getQuantityReps();
        Integer resTimeSeconds = exerciseRequest.getResTimeSeconds();
        return exerciseService.createExercise(name, quantitySets, quantityReps, resTimeSeconds);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Exercise>> getExerciseById(@PathVariable String id) {
        return new ResponseEntity<Optional<Exercise>>(exerciseService.exerciseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Exercise updateExercise(@PathVariable String id, @RequestBody ExerciseRequest exerciseRequest) {
        return exerciseService.updateExercise(id, exerciseRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable String id) {
        exerciseService.deleteExerciseById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
