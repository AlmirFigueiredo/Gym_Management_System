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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;
import com.josealmir.gymmanagementsystem.model.workoutplan.strategies.CardioStrategy;
import com.josealmir.gymmanagementsystem.model.workoutplan.strategies.StrengthTrainingStrategy;
import com.josealmir.gymmanagementsystem.model.workoutplan.strategies.WorkoutStrategy;
import com.josealmir.gymmanagementsystem.requests.WorkoutPlanRequest;
import com.josealmir.gymmanagementsystem.service.interfaces.WorkoutPlanService;

@RestController
@RequestMapping("/WorkoutPlans")
public class WorkoutPlanController {
    @Autowired
    private WorkoutPlanService workoutPlanService;

    @GetMapping
    public ResponseEntity<List<WorkoutPlan>> getAllWorkoutPlans() {
        return new ResponseEntity<>(workoutPlanService.allWorkoutPlans(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<WorkoutPlan>> getWorkoutByIds(@PathVariable String id) {
        return new ResponseEntity<>(workoutPlanService.findWorkoutPlanById(id), HttpStatus.OK);
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<WorkoutPlan>> getWorkoutPlansByMemberId(@PathVariable String memberId) {
        return new ResponseEntity<>(workoutPlanService.findWorkoutPlansByMemberId(memberId), HttpStatus.OK);
    }

    @PostMapping
    public WorkoutPlan createWorkoutPlan(@RequestBody WorkoutPlanRequest workoutPlanRequest) {
        return workoutPlanService.createWorkoutPlan(
            workoutPlanRequest.getMemberId(),
            workoutPlanRequest.getTrainerId(),
            workoutPlanRequest.getStartDate(),
            workoutPlanRequest.getEndDate(),
            workoutPlanRequest.getDailyWorkouts()
        );
    }

    @PutMapping("/{id}")
    public WorkoutPlan updateWorkoutPlan(@PathVariable String id, @RequestBody WorkoutPlanRequest workoutPlanRequest) {
        return workoutPlanService.updateWorkoutPlan(id, workoutPlanRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIds(@PathVariable String id) {
        workoutPlanService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/withStrategy")
    public WorkoutPlan createWorkoutPlanWithStrategy(@RequestBody WorkoutPlanRequest workoutPlanRequest, @RequestParam String strategyType) {
        WorkoutStrategy strategy;
        switch (strategyType.toLowerCase()) {
            case "cardio":
                strategy = new CardioStrategy();
                break;
            case "strength":
                strategy = new StrengthTrainingStrategy();
                break;
            default:
                throw new IllegalArgumentException("Invalid strategy type");
        }
        return workoutPlanService.createWorkoutPlanWithStrategy(
            workoutPlanRequest.getMemberId(),
            workoutPlanRequest.getTrainerId(),
            workoutPlanRequest.getStartDate(),
            workoutPlanRequest.getEndDate(),
            strategy
        );
    }
}
