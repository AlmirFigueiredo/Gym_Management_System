package com.josealmir.gymmanagementsystem.service.interfaces;

import java.util.List;

import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.model.person.Trainer;
import com.josealmir.gymmanagementsystem.model.workoutplan.DailyWorkout;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;

public interface WorkoutPlanService {
    WorkoutPlan createWorkoutPlan(Member member, Trainer trainer, String startDate, String endDate, List<DailyWorkout> dailyWorkouts);
    List<WorkoutPlan> allWorkoutPlans();
}
