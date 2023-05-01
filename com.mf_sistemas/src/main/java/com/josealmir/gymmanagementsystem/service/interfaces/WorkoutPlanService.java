package com.josealmir.gymmanagementsystem.service.interfaces;

import java.util.List;
import java.util.Optional;
import com.josealmir.gymmanagementsystem.model.workoutplan.DailyWorkout;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;

public interface WorkoutPlanService {
    WorkoutPlan createWorkoutPlan(String memberId, String trainerId, String startDate, String endDate, List<DailyWorkout> dailyWorkouts);
    List<WorkoutPlan> allWorkoutPlans();
    Optional<WorkoutPlan> findWorkoutPlanByIds(String trainerId, String memberId);
    Optional<WorkoutPlan> findWorkoutPlanById(String id);
    void deleteById(String id);
    void deleteByIds(String trainerId, String memberId);
}
