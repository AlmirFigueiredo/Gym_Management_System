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

import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;
import com.josealmir.gymmanagementsystem.service.interfaces.WorkoutPlanService;

@RestController
@RequestMapping("/WorkoutPlans")
public class WorkoutPlanController {
    @Autowired
    private WorkoutPlanService workoutPlanService;

    @GetMapping
    public ResponseEntity<List<WorkoutPlan>> getAllWorkoutPlans() {
        return new ResponseEntity<List<WorkoutPlan>>(workoutPlanService.allWorkoutPlans(), HttpStatus.OK);
    }
    @GetMapping("/{memberId}/{trainerId}")
    public ResponseEntity<Optional<WorkoutPlan>> getWorkoutByIds(@PathVariable String memberId, @PathVariable String trainerId) {
        return new ResponseEntity<Optional<WorkoutPlan>>(workoutPlanService.findWorkoutPlanByIds(trainerId, memberId), HttpStatus.OK);
    }
   
    @DeleteMapping("/{memberId}/{trainerId}")
    public ResponseEntity<Void> deleteByIds(@PathVariable String memberId, @PathVariable String trainerId) {
        workoutPlanService.deleteByIds(trainerId, memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
