package com.josealmir.gymmanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josealmir.gymmanagementsystem.service.interfaces.ExerciseService;

@RestController
@RequestMapping("/Exercises")
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    
}
