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

import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.model.person.Trainer;
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

    @PostMapping
    public WorkoutPlan createWorkoutPlan(@RequestBody WorkoutPlanRequest workoutPlanRequest) {
        Member member = workoutPlanRequest.getMember();
        Trainer trainer = workoutPlanRequest.getTrainer();
        String startDate = workoutPlanRequest.getStartDate();
        String endDate = workoutPlanRequest.getEndDate();
        List<DailyWorkout> dailyWorkouts = workoutPlanRequest.getDailyWorkouts();
        return workoutPlanService.createWorkoutPlan(member, trainer, startDate, endDate, dailyWorkouts);
    }
    @GetMapping("/{memberId}{trainerId}")
    public ResponseEntity<Optional<WorkoutPlan>> getWorkoutPlanByIds(@PathVariable String memberId, String trainerId) {
        return new ResponseEntity<Optional<WorkoutPlan>>(workoutPlanService.findWorkoutPlanByIds(memberId, trainerId), HttpStatus.OK);
    }
    @DeleteMapping("/{memberId}{trainerId}")
    public ResponseEntity<Void> deleteByIds(@PathVariable String memberId, String trainerId) {
        workoutPlanService.deleteByIds(trainerId, memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
