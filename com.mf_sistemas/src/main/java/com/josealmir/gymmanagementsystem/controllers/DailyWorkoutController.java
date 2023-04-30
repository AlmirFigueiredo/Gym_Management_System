package com.josealmir.gymmanagementsystem.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josealmir.gymmanagementsystem.model.workoutplan.DailyWorkout;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;
import com.josealmir.gymmanagementsystem.service.interfaces.DailyWorkoutService;

@RestController
@RequestMapping("/DailyWorkouts")
public class DailyWorkoutController {
    @Autowired
    private DailyWorkoutService dailyWorkoutService;

    @GetMapping
    public ResponseEntity<List<DailyWorkout>> getAllDailyWorkouts() {
        return new ResponseEntity<List<DailyWorkout>>(dailyWorkoutService.allDailyWorkouts(), HttpStatus.OK);
    }

    @PostMapping
    public WorkoutPlan createWorkoutPlan(@RequestBody DailyWorkout dailyWorkout) {
        
    }

}
