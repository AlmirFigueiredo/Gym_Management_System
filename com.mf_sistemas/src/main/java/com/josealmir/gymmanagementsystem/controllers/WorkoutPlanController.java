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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josealmir.gymmanagementsystem.model.workoutplan.DailyWorkout;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;
import com.josealmir.gymmanagementsystem.requests.WorkoutPlanRequest;
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

    @GetMapping("/{id}")
    public ResponseEntity<Optional<WorkoutPlan>> getWorkoutByIds(@PathVariable String id) {
        return new ResponseEntity<Optional<WorkoutPlan>>(workoutPlanService.findWorkoutPlanById(id), HttpStatus.OK);
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<WorkoutPlan>> getWorkoutPlansByMemberId(@PathVariable String memberId) {
        return new ResponseEntity<>(workoutPlanService.findWorkoutPlansByMemberId(memberId), HttpStatus.OK);
    }

    @PostMapping
    public WorkoutPlan createWorkoutPlan(@RequestBody WorkoutPlanRequest workoutPlanRequest) {
        String memberId = workoutPlanRequest.getMemberId();
        String trainerId = workoutPlanRequest.getTrainerId();
        String startDate = workoutPlanRequest.getStartDate();
        String endDate = workoutPlanRequest.getEndDate();
        List<DailyWorkout> dailyWorkouts = workoutPlanRequest.getDailyWorkouts();
        return workoutPlanService.createWorkoutPlan(memberId, trainerId, startDate, endDate, dailyWorkouts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIds(@PathVariable String id) {
        workoutPlanService.deleteById(id);
        ;
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
