package com.josealmir.gymmanagementsystem.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josealmir.gymmanagementsystem.model.workoutplan.Exercise;
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

    @GetMapping("/{name}")
    public ResponseEntity<Optional<Exercise>> getExerciseByName(@PathVariable String name) {
        return new ResponseEntity<Optional<Exercise>>(exerciseService.exerciseByName(name), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteExercise(@PathVariable String name) {
        exerciseService.deleteExerciseByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
