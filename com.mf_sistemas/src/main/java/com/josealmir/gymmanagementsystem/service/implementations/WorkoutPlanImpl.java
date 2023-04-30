package com.josealmir.gymmanagementsystem.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.model.person.Trainer;
import com.josealmir.gymmanagementsystem.model.workoutplan.DailyWorkout;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;
import com.josealmir.gymmanagementsystem.repositories.WorkoutPlanRepository;
import com.josealmir.gymmanagementsystem.service.interfaces.WorkoutPlanService;

@Service
public class WorkoutPlanImpl implements WorkoutPlanService {
    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;
    @Override
    public WorkoutPlan createWorkoutPlan(Member member, Trainer trainer, String startDate, String endDate, List<DailyWorkout> dailyWorkouts) {
        WorkoutPlan workoutPlan = workoutPlanRepository.insert(new WorkoutPlan(member, trainer, startDate, endDate, dailyWorkouts));
        return workoutPlan;
    }
}
